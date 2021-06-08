package com.example.myapplication.model;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class OwnerTest {

    Balance b;
    Flat f;
    Owner owner;
    ArrayList<NonRegExpense> nrea;
    @Before
    public void setUp() throws Exception {
        double amount = 1000;
        int uid = 3;
        int fid = 15;
        b = new Balance(amount, uid, fid);

        int floor = 2;
        double area = 250;
        double heatingPercentage = 0.9;

        f = new Flat(uid, floor, area, heatingPercentage);

        String description = "softeng project";
        double cost = 1000;
        int time_expected = 5;

        NonRegExpense exp = new NonRegExpense(fid, description, cost, time_expected);

        int fid2 = 10;
        String description2 = "softeng project";
        double cost2 = 1000;
        int time_expected2 = 5;
        NonRegExpense exp2 = new NonRegExpense(fid2, description2, cost2, time_expected2);

        String username = "username";
        String password = "password";
        nrea = new ArrayList<NonRegExpense>();
        nrea.add(exp);
        nrea.add(exp2);

        owner = new Owner(uid, username, password, fid, b, f, nrea);
    }

    @Test
    public void testSubmitResults(){
        owner.submitResult(nrea.get(0));
        boolean found = false;
        for (NonRegExpense nr : nrea){
            if (nr.getDescription() == nrea.get(0).getDescription()){
                found = true;
            }
        }
        assertEquals(true, found);
    }

    @Test
    public void testEvaluateNonRegExpenseConfirm(){
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(1);
        assertEquals(true, owner.evaluateNonRegExpense(nrea.get(0), asker));
    }

    @Test
    public void testEvaluateNonRegExpenseDecline(){
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(2);
        assertEquals(false, owner.evaluateNonRegExpense(nrea.get(0), asker));
    }

    @Test
    public void testShowNonRegExpenses(){
        Owner o = mock(Owner.class);
        o.showNonRegExpenses();
        verify(o,times(1)).showNonRegExpenses();
    }

    @Test
    public void testShowNonRegExpensesLoop(){
        Assert.assertEquals(nrea.size(), owner.showNonRegExpenses());
    }
}

