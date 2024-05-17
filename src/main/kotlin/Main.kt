

import console.Console
import dao.BookDAO
import db.DataSourceFactory
import service.BookServiceImpl
import java.util.*

fun main() {
    val console = Console()
    val datasource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)
    val bookDAO = BookDAO(datasource, console)
    val bookService = BookServiceImpl(bookDAO)

    val newBook = Book(title = "City of Glass", author ="Paul Auster", theme = "Detectivesca", published = 1985)
    var createdBook = newBook.let { bookService.createBook(it) }
    console.escribir("Created user: $createdBook")

    val foundBook = createdBook?.let { bookService.getByBookId(it.id) }
    console.escribir("Found user: $foundBook")

    val updatedBook = foundBook?.copy(title = "City of Glass")
    val savedBook = updatedBook?.let { bookService.updateBook(it) }
    console.escribir("Updated user: $savedBook")

    val otherBook = Book(UUID.randomUUID(), "The Yellow Wallpaper", "Charlotte Perkins Gilman", "Ficción", 1892)

    createdBook = bookService.createBook( otherBook)
    console.escribir("Created user: $createdBook")

    // Obtenemos todos los libros
    var allBooks = bookService.getAllBooks()
    console.escribir(allBooks.toString())

    // Eliminamos el libro
    if (savedBook != null) {
        bookService.deleteBook(savedBook.id)
    }
    console.escribir("Book deleted")

    // Obtenemos todos los libros
    allBooks = bookService.getAllBooks()
    console.escribir("All books: $allBooks")

    // Eliminamos el libro
    bookService.deleteBook(otherBook.id)
    console.escribir("Book deleted")
}