package dao
import Book
import java.util.*

interface IBookDAO {
    fun createBook(book: Book): Book?
    fun getAllBooks(): List<Book>?
    fun getBookById(id: UUID): Book?
    fun updateBooks(book: Book): Book?
    fun deleteBook(id: UUID): Boolean
}