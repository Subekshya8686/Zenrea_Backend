package com.example.zenrea_backend;

        import com.example.zenrea_backend.entity.Card;
        import com.example.zenrea_backend.repository.CardRepository;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.MethodOrderer;
        import org.junit.jupiter.api.Order;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestMethodOrder;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.annotation.Rollback;

        import java.util.List;
        import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardRepositoryTest {


    @Autowired
    private CardRepository cardRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem(){
        Card card= new Card();

        card.setDescription("Testing description");
        card.setTitle("Testing item name");
        card.setImage("1200");

        card=cardRepository.save(card);

        Assertions.assertThat(card.getId()).isGreaterThan(0);


    }


    @Test
    @Order(2)
    public void findById(){
        Card item= cardRepository.findById(1L).get();
        Assertions.assertThat(item.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAllData(){
        List<Card> itemList= cardRepository.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateItem(){
        Card item= cardRepository.findById(1L).get();
        item.setTitle("updated testing item name");
        item=cardRepository.save(item);

        Assertions.assertThat(item.getTitle()).isEqualTo("updated testing item name");
    }

    @Test
    @Order(5)
    public void DeleteByID(){
        cardRepository.deleteById(1L);

        Card item1=null;

        Optional<Card> item=cardRepository.findById(1L);

        if(item.isPresent()){
            item1=item.get();
        }

        Assertions.assertThat(item1).isNull();

    }
}