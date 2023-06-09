package com.example.catalogsvc.repository.impl;

import com.example.catalogsvc.model.Product;
import com.example.catalogsvc.repository.ProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductRepositoryImpl implements ProductRepository {

    private final ArrayList<Product> products = new ArrayList<>();

    public ProductRepositoryImpl(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                products.add(readProductFromLine(line.split("\t")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // can be a mapper in some future
    private Product readProductFromLine(String[] columnValues) {
        String[] preparedColumnValues = new String[14];
        for (int i = 0; i < 14; i++) {
            if (i < columnValues.length) {
                if (columnValues[i] == null) columnValues[i] = "";
                preparedColumnValues[i] = columnValues[i];
            } else {
                preparedColumnValues[i] = "";
            }
        }
        Product resultProduct = new Product();
        resultProduct.setUniqId(preparedColumnValues[0]);
        resultProduct.setSku(preparedColumnValues[1]);
        resultProduct.setTitle(preparedColumnValues[2]);
        resultProduct.setDescription(preparedColumnValues[3]);
        resultProduct.setDistPrice(preparedColumnValues[4].equals("") || !isNumeric(preparedColumnValues[4]) ? 0 : Double.parseDouble(preparedColumnValues[4]));
        resultProduct.setSalePrice(preparedColumnValues[5].equals("") || !isNumeric(preparedColumnValues[5]) ? 0 : Double.parseDouble(preparedColumnValues[5]));
        resultProduct.setCategory(preparedColumnValues[6]);
        resultProduct.setCategoryTree(preparedColumnValues[7]);
        resultProduct.setAverageProductRating(preparedColumnValues[8]);
        resultProduct.setProductUrl(preparedColumnValues[9]);
        resultProduct.setProductImageUrls(retrieveImageUrls(preparedColumnValues[10]));
        resultProduct.setBrand(preparedColumnValues[11]);
        resultProduct.setTotalNumberReviews(preparedColumnValues[12].equals("") || !isNumeric(preparedColumnValues[12])  ? 0 : Integer.parseInt(preparedColumnValues[12]));
        resultProduct.setReviews(retrieveReviews(preparedColumnValues[13]));
        return resultProduct;
    }

    public Product getProductByUniqId(String uniqId) {
        for (var product : products) {
            if (product.getUniqId().equals(uniqId)) return product;
        }
        return null;
    }

    public List<Product> getProductsBySku(String sku) {
        return products.stream().filter(p -> p.getSku().equals(sku)).toList();
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private List<String> retrieveImageUrls(String urls) {
        return Arrays.stream(urls.split("\\|")).filter(u -> !u.equals("/dotcom/images/playbutton.svg")).toList();
    }

    private List<String> retrieveReviews(String reviews) {
        // Pattern to find the reviews
        Pattern pattern = Pattern.compile("\"review_\\d+\"=>\"(.*?)\"");

        // Matcher object
        Matcher matcher = pattern.matcher(reviews);

        List<String> reviewList = new ArrayList<>();

        // While loop to find all the matches
        while (matcher.find()) {
            // add matched string (group 1) to the list
            reviewList.add(matcher.group(1));
        }
        return reviewList;
    }

}
