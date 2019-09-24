package article.service;

import java.util.List;

import article.model.FreeboardArticle;

public class FreeboardArticlePage {
	private int total;
	private int currentPage;
	private List<FreeboardArticle> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	public FreeboardArticlePage(int total, int currentPage, int size, List<FreeboardArticle> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			totalPages = total/size;
			if(total%size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage /5 * 5 + 1;
			if(modVal == 0) startPage -=5;
			endPage = startPage + 4;
			if(endPage > totalPages) endPage = totalPages;
		}
	}
	public boolean hasNoArticles() {
		return total == 0;
	}
	public boolean hasArticles() {
		return total > 0;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<FreeboardArticle> getContent() {
		return content;
	}

	public void setContent(List<FreeboardArticle> content) {
		this.content = content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
