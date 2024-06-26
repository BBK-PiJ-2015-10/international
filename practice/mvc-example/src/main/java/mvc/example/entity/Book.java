package mvc.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOK_TBL")
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private double price;

}
