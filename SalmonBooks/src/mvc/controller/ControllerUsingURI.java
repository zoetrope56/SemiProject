package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class ControllerUsingURI extends HttpServlet{
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<String, CommandHandler>();

	public void init() throws ServletException{
		System.out.println("[ControllerURI] init()...");
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		System.out.println("[ControllerUsingURI] "+ configFilePath);
		try(FileReader fileReader = new FileReader(configFilePath)){
			prop.load(fileReader);
		}catch(IOException e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler)handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
				System.out.println("[ControllerUsingURI] "+command);
			}catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
		System.out.println("[ControllerUsingURI] initComplite");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	public void process(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException{
		String command = req.getRequestURI();
		System.out.println("[ControllerURI] command : " + command);
		if(command.indexOf(req.getContextPath())==0) {
			command = command.substring(req.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(req, res);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		if(viewPage!=null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
	}
}
