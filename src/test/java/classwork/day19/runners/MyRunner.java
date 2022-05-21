package classwork.day19.runners;

import classwork.day20.MyParser;

import java.io.FileNotFoundException;

public class MyRunner {

    public static void main(String[] args) throws FileNotFoundException {
        MyParser parser = new MyParser();
        parser.parseGSON();
    }
}
