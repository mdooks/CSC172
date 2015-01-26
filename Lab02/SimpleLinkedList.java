/*
 * Lab2
 *
 * Lab 2
 *
 * Copyright 2015
 *
 * Course: CSC 172 Spring 2015
 *
 * Assignment: Lab 2
 *
 * Author: Nicholas Graham
 *
 * Lab Session: Wednesday 6:15 - 7:30
 *
 * Lab TA: Kate Zeng Zhiming
 *
 * Last Revised: January 25, 2014.
 */
 public interface SimpleLinkedList<AnyType> {
  public void insert(AnyType x);
  public void delete(AnyType x);
  public AnyType lookup(AnyType x);
  public boolean isEmpty();
  public void printlist();
}
