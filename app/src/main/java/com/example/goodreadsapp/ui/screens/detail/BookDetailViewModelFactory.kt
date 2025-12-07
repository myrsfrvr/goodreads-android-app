import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.goodreadsapp.data.repository.BookDetailRepository
import com.example.goodreadsapp.ui.screens.detail.BookDetailViewModel

class BookDetailViewModelFactory(
    private val repository: BookDetailRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
