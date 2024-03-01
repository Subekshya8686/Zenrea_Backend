package com.example.zenrea_backend;




import com.example.zenrea_backend.entity.Board;
import com.example.zenrea_backend.repository.BoardRepository;
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
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem(){
        Board board= new Board();

        board.setBoardName("Testing item name");


        board=boardRepository.save(board);

        Assertions.assertThat(board.getId()).isGreaterThan(0);


    }


    @Test
    @Order(2)
    public void findById(){
        Board board= boardRepository.findById(1L).get();
        Assertions.assertThat(board.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAllData(){
        List<Board> itemList= boardRepository.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateItem(){
        Board board= boardRepository.findById(1L).get();
        board.setBoardName("updated testing item name");
        board=boardRepository.save(board);

        Assertions.assertThat(board.getBoardName()).isEqualTo("updated testing item name");
    }

    @Test
    @Order(5)
    public void DeleteByID(){
        boardRepository.deleteById(1L);

        Board item1=null;

        Optional<Board> item=boardRepository.findById(1L);

        if(item.isPresent()){
            item1=item.get();
        }

        Assertions.assertThat(item1).isNull();

    }
}
