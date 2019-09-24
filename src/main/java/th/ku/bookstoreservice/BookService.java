package th.ku.bookstoreservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/book"})
public class BookService {

    @Autowired
    private BookDaoImp repository;

    @GetMapping
    public List<Book> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        repository.save(book);
        return repository.findById(book.getId());
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        repository.update(id, book);
        return repository.findById(id);

    }

    @DeleteMapping("/{id}")
    public Book delete(@PathVariable int id) {
        Book book = repository.findById(id);
        repository.deleteById(id);
        return book;
    }



}
