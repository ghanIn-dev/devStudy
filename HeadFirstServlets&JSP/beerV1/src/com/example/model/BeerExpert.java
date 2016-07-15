package com.example.model;
import java.util.*;

public class BeerExpert{
  public ArrayList getBrands(String color){

    List<String> brands = new ArrayList<String>(50);

    if(color.equals("amber")){
      brands.add("Jack Amber");
      brands.add("Red Moose");
    }
    else{
      brands.add("Jail Pale Ale");
      brands.add("Gout Stout");
    }
    return((ArrayList)brands);
  }
}
