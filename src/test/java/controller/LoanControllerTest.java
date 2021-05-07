package controller;

import com.example.loanservice.controller.LoanController;
import com.example.loanservice.model.LoanDetails;
import com.example.loanservice.model.LoanType;
import com.example.loanservice.repository.LoanRepository;
import com.example.loanservice.service.LoanService;
import com.example.loanservice.service.LoanServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class LoanControllerTest {

    private LoanController loanController;

    @Mock
    private LoanService loanService;

    private LoanRepository loanRepository;

    @Before
    public void setUp() {
        loanService = mock(LoanServiceImpl.class);
        loanController = new LoanController(loanService);
        loanRepository = mock(LoanRepository.class);
    }

    @Test
    public void testSaveLoanDetails() {
        LoanDetails loanDetails = LoanDetails.builder().loanId(1).loanType(LoanType.CAR_LOAN).userId(6)
                .durationOfLoan(2).loanAmount(1000).rateOfInterest(2).build();
        when(loanService.insert(loanDetails)).thenReturn(loanDetails);
        ResponseEntity<LoanDetails> responseEntity = loanController.saveLoanDetails(loanDetails);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void testFindAll() {

        LoanDetails loanDetails = LoanDetails.builder().loanId(1).loanType(LoanType.CAR_LOAN).userId(6)
                .durationOfLoan(2).loanAmount(1000).rateOfInterest(2).build();
        LoanDetails loanDetails1 = LoanDetails.builder().loanId(1).loanType(LoanType.EDUCATIONAL_LOAN).userId(6)
                .durationOfLoan(2).loanAmount(1000).rateOfInterest(2).build();
        List<LoanDetails> list = new ArrayList<>();
        list.addAll(Arrays.asList(loanDetails, loanDetails1));

        when(loanService.findByUserId(6)).thenReturn(list);
        // when
        ResponseEntity<List<LoanDetails>> result = loanController.showLoans(6);

        // then
        assertThat(result.getBody().size()).isEqualTo(2);
    }
}
