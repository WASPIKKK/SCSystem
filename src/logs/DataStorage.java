package logs;

import core.Store;
import product.Brand;
import product.Product;
import product.Supplier;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private final File fileWithProducts = new File("src/logs/csv/listProduct.csv");
    private final File fileWithError = new File("src/logs/sys/error.txt");

    public void writeToFile(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWithProducts, true))) {
            if (fileWithProducts.exists() && fileWithProducts.length() <= 3) {
                writer.write("\uFEFF" + "ID;" + "Название;" + "Бренд;" + "Поставщик;" + "Дата;");
                writer.write("\n");
            }
            writer.write(product.getId() + ";");
            writer.write(product.getName() + ";");
            writer.write(product.getBrand().getName() + ";");
            writer.write(product.getSupplier().getName() + ";");
            writer.write(product.getDate() + ";");
            writer.write("\n");
        } catch (IOException exception) {
            writeErrors(exception);
        }
    }


/*    Читаем файл построчно.
    Пропускаем строку, которую нужно удалить.
    Записываем оставшиеся строки в новый файл.
    После завершения записи, заменяем старый файл на новый.*/

/*    public void removeWithFile(Product product) {
        File localFile = new File("src/logs/csv/tempListProduct.csv");
        // File localFile = File.createTempFile("test", ".txt", new File("src/logs/csv/"));
        if (fileWithProducts.exists() && fileWithProducts.length() <= 3) return;
        if (!searchInFile(product)) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileWithProducts));
             BufferedWriter writer = new BufferedWriter(new FileWriter(localFile))) {
            String tempLine;
            while ((tempLine = reader.readLine()) != null) {
                if (tempLine.contains("ID")) {
                    writer.write(tempLine + "\n");
                    continue;
                }
                if (product.getId() != Integer.parseInt(tempLine.substring(0, tempLine.indexOf(';')))) {
                    writer.write(tempLine + "\n");
                }
            }
        } catch (IOException exception) {
            writeErrors(exception);
        }
        if (!fileWithProducts.delete()) {
            System.out.println("файл не удалился");
        }
        if (!localFile.renameTo(fileWithProducts)) {
            System.out.println("файл не смог переменоваться");
        }
    }*/

    public <T> void removeWithFileLast(List<T> list) {
        List<T> afterCheckerList = checkWithFiles(list);
        if (afterCheckerList.isEmpty()) return;
        System.out.println(afterCheckerList);
        boolean isNumber = afterCheckerList.get(0) instanceof Number;
        File localFile = new File("src/logs/csv/localTempFile.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileWithProducts));
             BufferedWriter writer = new BufferedWriter(new FileWriter(localFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID")) {
                    writer.write(line);
                    writer.write("\n");
                    continue;
                }
                int localIndex = 0;
                int lineId = Integer.parseInt(line.substring(0, line.indexOf(";")));
                for (T id : afterCheckerList) {
                    localIndex++;
                    int localI = isNumber ? (Integer) id : ((Product) id).getId();
                    // String localId = isNumber ? String.valueOf(id) : String.valueOf(((Product) id).getId());
                    if (lineId == localI) {
                        break;
                    }
                    if (afterCheckerList.size() == localIndex) {
                        writer.write(line);
                        writer.write("\n");
                    }
                }
/*                if (isNumber) {
                    for (T number : list) {
                        String strId = (line.substring(0, line.indexOf(";")));
                        localIndex++;
                        if (strId.contains(String.valueOf(number))) {
                            break;
                        }
                        if (list.size() == localIndex) {
                            writer.write(line);
                            writer.write("\n");
                        }
                    }
                } else {
                    for (T number : list) {
                        Product product = (Product) number;
                        String strId = (line.substring(0, line.indexOf(";")));
                        localIndex++;
                        if (strId.contains(String.valueOf(product.getId()))) {
                            break;
                        }
                        if (list.size() == localIndex) {
                            writer.write(line);
                            writer.write("\n");
                        }
                    }
                }
            }*/

            }
        } catch (IOException exception) {
            writeErrors(exception);
        }
        if (!fileWithProducts.delete()) {
            writeErrors(new RuntimeException("Файл \"" + fileWithProducts.getName() + "\" не удалился"));
        }
        if (!localFile.renameTo(fileWithProducts)) {
            writeErrors(new RuntimeException("Файл \"" + fileWithProducts.getName() + "\" не смог переменоваться"));
        }

    }


    public <T> List<T> checkWithFiles(List<T> listProductsOrId) {
        List<T> listId = new ArrayList<>();
        List<T> listProducts = new ArrayList<>();
        boolean isNumber = listProductsOrId.get(0) instanceof Number;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileWithProducts))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID")) continue;
                int lineId = Integer.parseInt(line.substring(0, line.indexOf(";")));
                for (T id : listProductsOrId) {
                    int tempId = isNumber ? (Integer) id : ((Product) id).getId();
                    if (isNumber && tempId == lineId) {
                        listId.add(id);
                    }
                    if (!isNumber && tempId == lineId) {
                        listProducts.add(id);
                    }
                }

/*
                if (isNumber) {
                    for (T id : listPrdOrId) {
                        if ((Integer) id == productId) {
                            listId.add(id);
                        }
                    }
                } else {
                    for (T obj : listPrdOrId) {
                        Product localProduct = (Product) obj;
                        if (localProduct.getId() == productId) {
                            otherList.add(obj);
                        }
                    }
                }
*/

            }

        } catch (IOException exception) {
            writeErrors(exception);
        }

        return isNumber ? listId : listProducts;
    }

    public void writeErrors(Exception exception) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileWithError, true))) {
            writer.write(LocalDate.now() + "|" + exception);
            writer.write("\n");
        } catch (IOException ioException) {
            throw new RuntimeException("Ошибка при записи в файл", ioException);
        }
    }

}
