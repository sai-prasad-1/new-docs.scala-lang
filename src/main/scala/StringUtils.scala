/** Utility object for string operations.
  *
  * This object provides various methods for manipulating strings.
  */
object StringUtils {

  /** Reverses a string.
    *
    * @param s the string to reverse
    * @return the reversed string
    */
  def reverse(s: String): String = s.reverse

  /** Converts a string to uppercase.
    *
    * @param s the string to convert
    * @return the uppercase string
    */
  def toUpperCase(s: String): String = s.toUpperCase

  /** Checks if a string is a palindrome.
    *
    * @param s the string to check
    * @return true if the string is a palindrome, false otherwise
    */
  def isPalindrome(s: String): Boolean = s == s.reverse
}
