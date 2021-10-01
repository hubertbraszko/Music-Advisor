package advisor;

import java.util.List;
import java.lang.Math;

public class ResponseHandler {

    private List<String> data;
    private int itemsPerPage=5;
    private int currentPage = 1;
    private int numOfPages;
    private boolean update = true;

    public ResponseHandler() {
        this.itemsPerPage = Integer.parseInt(Config.ITEMSPERPAGE.get());
    }

    public void print() {
        if(update) {
            for (int i = (currentPage - 1) * itemsPerPage; i < itemsPerPage + (currentPage - 1) * itemsPerPage; i++) {
                System.out.println(data.get(i));
            }
            System.out.println("---PAGE " + currentPage + " OF " + numOfPages + "---");
        }
    }

    public void nextPage() {
        if(currentPage + 1 >numOfPages) {
            System.out.println("No more pages.");
            this.update=false;
        } else {
            currentPage++;
            this.update=true;
        }
    }

    public void previousPage() {
        if(currentPage - 1 < 1) {
            System.out.println("No more pages.");
            this.update=false;
        } else {
            currentPage--;
            this.update=true;
        }
    }



    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        if(data != null) {
            this.update = true;
            this.data = data;
            numOfPages = (int) Math.ceil(data.size() / (float)itemsPerPage);
            if(data.size() < itemsPerPage) {
                itemsPerPage = data.size();
            }
        }
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }
}
