public static Shunting-Yard {
  public Stack<AnyType> expressionStack;
  public Queue<AnyType> expressionQueue;

  public Shunting-Yard{
    expressionStack = new Stack<AnyType>();
    expressionQueue = new Queue<AnyType>();
  }
}
