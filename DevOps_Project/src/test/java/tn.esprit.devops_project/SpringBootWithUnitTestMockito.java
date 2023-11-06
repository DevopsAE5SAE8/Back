package tn.esprit.devops_project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SpringBootWithUnitTestMockito {
    @Mock
    OperatorRepository operatorRepository;
    @InjectMocks
    OperatorServiceImpl operatorService;

    Operator operator = Operator.builder().lname("zied").fname("hrzlh").password("zied123").build();
    List<Operator> list= new ArrayList<Operator>(){
        {
            add(Operator.builder().lname("abdel").fname("elloumi").password("abdel123").build());
            add(Operator.builder().lname("louay").fname("sghir").password("louay123").build());
        }
    };

    @Test
    public void testRetrieveAllOperators() {
        // Mock the behavior of operatorRepository.findAll()
        when(operatorRepository.findAll()).thenReturn(List.of(new Operator(), new Operator()));

        // Perform the test
        List<Operator> operators = operatorService.retrieveAllOperators();

        // Verify the result
        assertEquals(2, operators.size());
    }

    @Test
    public void testAddOperator() {
        Operator operatorToAdd = new Operator();

        // Mock the behavior of operatorRepository.save()
        when(operatorRepository.save(operatorToAdd)).thenReturn(operatorToAdd);

        // Perform the test
        Operator addedOperator = operatorService.addOperator(operatorToAdd);

        // Verify the result
        assertEquals(operatorToAdd, addedOperator);
    }

    @Test
    public void testDeleteOperator() {
        Long operatorId = 1L;

        // Mock the behavior of operatorRepository.deleteById()
        doNothing().when(operatorRepository).deleteById(operatorId);

        // Perform the test
        operatorService.deleteOperator(operatorId);

        // Verify that deleteById was called with the specified ID
        verify(operatorRepository).deleteById(operatorId);
    }

    @Test
    public void testUpdateOperator() {
        Operator operatorToUpdate = new Operator();

        // Mock the behavior of operatorRepository.save()
        when(operatorRepository.save(operatorToUpdate)).thenReturn(operatorToUpdate);

        // Perform the test
        Operator updatedOperator = operatorService.updateOperator(operatorToUpdate);

        // Verify the result
        assertEquals(operatorToUpdate, updatedOperator);
    }

    @Test
    public void testRetrieveOperatorSuccess() {
        Long operatorId = 1L;
        Operator operator = new Operator();

        // Mock the behavior of operatorRepository.findById()
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));

        // Perform the test
        Operator retrievedOperator = operatorService.retrieveOperator(operatorId);

        // Verify the result
        assertEquals(operator, retrievedOperator);
    }

    @Test
    public void testRetrieveOperatorNotFound() {
        Long operatorId = 1L;

        // Mock the behavior of operatorRepository.findById()
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.empty());

        // Perform the test
        assertThrows(NullPointerException.class, () -> operatorService.retrieveOperator(operatorId));
    }

}
