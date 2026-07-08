import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuItem>menuItems;

    public Menu(List<MenuItem>menuItems){
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void displayMenu(){
        int id = 1;
        for(MenuItem curItem:menuItems){
            System.out.printf("%d - " , id);
            curItem.displayItem();
            System.out.println("-----------");
            ++id;
        }
        System.out.println("-----------");
    }

    public MenuItem getItem(int choice) {
        if (choice > 0 && choice <= menuItems.size()) {
            return menuItems.get(choice - 1);
        }
        return null;
    }

}
