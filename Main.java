package topsalesman;

public class Main {
    public static void main(String[] args) {
        Salesman[] allSales = new Salesman[9];
        allSales[0] = new Salesman("Goku", 5264);
        allSales[1] = new Salesman("Brayan", 4569);
        allSales[2] = new Salesman("Magali", 2657);
        allSales[3] = new Salesman("Samantha", 1562);
        allSales[4] = new Salesman("Esmeralda", 654);
        allSales[5] = new Salesman("Jose", 864);
        allSales[6] = new Salesman("Carlos", 2654);
        allSales[7] = new Salesman("Juan", 1364);
        allSales[8] = new Salesman("John", 3654);

        // Get top 5 salesmen
        Salesman[] topSalesmen = getTopFive(allSales);
        for (Salesman salesman : topSalesmen) {
            if (salesman != null) {
                System.out.println(salesman.name + " : " + salesman.sales);
            }
        }
    }

    static class Salesman {
        String name;
        float sales;

        Salesman(String name, float sales) {
            this.name = name;
            this.sales = sales;
        }
    }

    public static Salesman[] getTopFive(Salesman[] allSales) {
        // Sort the array based on sales (Bubble Sort)
        for (int i = 0; i < allSales.length - 1; i++) {
            for (int j = 0; j < allSales.length - i - 1; j++) {
                if (allSales[j].sales < allSales[j + 1].sales) {
                    Salesman temp = allSales[j];
                    allSales[j] = allSales[j + 1];
                    allSales[j + 1] = temp;
                }
            }
        }

        // Create an array to hold the top 5 salesmen
        Salesman[] topFive = new Salesman[5];

        // Fill the topFive array
        for (int i = 0; i < 5 && i < allSales.length; i++) {
            topFive[i] = allSales[i];
        }
        
        return topFive;
    }
}