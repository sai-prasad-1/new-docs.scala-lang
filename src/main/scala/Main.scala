/** A simple calculator object for demonstrating Scaladoc.
  *
  * This object provides basic arithmetic operations.
  */
object Calculator {

  /** Adds two integers.
    *
    * @param a the first integer
    * @param b the second integer
    * @return the sum of `a` and `b`
    */
  def add(a: Int, b: Int): Int = a + b

  /** Subtracts the second integer from the first.
    *
    * @param a the first integer
    * @param b the second integer
    * @return the result of `a` minus `b`
    */
  def subtract(a: Int, b: Int): Int = a - b

  /** Multiplies two integers.
    *
    * @param a the first integer
    * @param b the second integer
    * @return the product of `a` and `b`
    */
  def multiply(a: Int, b: Int): Int = a * b

  /** Divides the first integer by the second.
    *
    * @param a the first integer
    * @param b the second integer
    * @return the quotient of `a` divided by `b`
    * @throws IllegalArgumentException if `b` is zero
    */
  @throws(classOf[IllegalArgumentException])
  def divide(a: Int, b: Int): Int = {
    if (b == 0) throw new IllegalArgumentException("Division by zero")
    a / b
  }
}
