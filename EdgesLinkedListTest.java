package nz.ac.auckland.softeng281.a4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EdgesLinkedListTest {

    EdgesLinkedList list;

    @Before
    public void setUp() {
        list = new EdgesLinkedList();
    }

    @Test
    public void testPrependandGetEmptyList() {
        list.prepend(new Edge(new Node("1"), new Node("2"), 1));
        
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(0));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getTailEdge());
    }
    
    @Test
    public void testPrependandGetB() {
        list.prepend(new Edge(new Node("1"), new Node("2"), 1));
        list.prepend(new Edge(new Node("2"), new Node("2"), 1));
        
        assertEquals(new Edge(new Node("2"), new Node("2"), 1), list.get(0));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(1));
        assertEquals(new Edge(new Node("2"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getTailEdge());
        
    }
    
    @Test
    public void testPrependandGetC() {
        list.prepend(new Edge(new Node("1"), new Node("2"), 1));
        list.prepend(new Edge(new Node("2"), new Node("2"), 1));
        list.prepend(new Edge(new Node("200"), new Node("200"), 1));
        
        assertEquals(new Edge(new Node("200"), new Node("200"), 1), list.get(0));
        assertEquals(new Edge(new Node("2"), new Node("2"), 1), list.get(1));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(2));
        assertEquals(new Edge(new Node("200"), new Node("200"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getTailEdge());
    }
    
    @Test
    public void testAppendandGetEmptyList() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(list.size()-1));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getTailEdge());
    }
    
    @Test
    public void testAppendandGetB() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(list.size()-1));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(list.size()-2));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(list.size()-3));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.getTailEdge());
    }
    
    @Test
    public void testAppendandGetC() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.append(new Edge(new Node("1000"), new Node("2000"), 1));
        list.append(new Edge(new Node("10000"), new Node("20000"), 1));
        
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.get(list.size()-1));
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.get(list.size()-2));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(list.size()-3));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(list.size()-4));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(list.size()-5));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.getTailEdge());
    }
    
    @Test
    public void testPrependandAppendandGetA() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.prepend(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.prepend(new Edge(new Node("1000"), new Node("2000"), 1));
        list.append(new Edge(new Node("10000"), new Node("20000"), 1));
        list.prepend(new Edge(new Node("100000"), new Node("200000"), 1));
        
        assertEquals(new Edge(new Node("100000"), new Node("200000"), 1), list.get(0));
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.get(1));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(2));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(3));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(4));
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.get(5));
        assertEquals(new Edge(new Node("100000"), new Node("200000"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.getTailEdge());
    }
    
    @Test
    public void testPrependandAppendandGetB() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.append(new Edge(new Node("1000"), new Node("2000"), 1));
        list.append(new Edge(new Node("10000"), new Node("20000"), 1));
        list.prepend(new Edge(new Node("4"), new Node("2"), 1));
        list.prepend(new Edge(new Node("40"), new Node("20"), 1));
        list.prepend(new Edge(new Node("400"), new Node("200"), 1));
        list.prepend(new Edge(new Node("4000"), new Node("2000"), 1));
        list.prepend(new Edge(new Node("40000"), new Node("20000"), 1));
        
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.get(0));
        assertEquals(new Edge(new Node("4000"), new Node("2000"), 1), list.get(1));
        assertEquals(new Edge(new Node("400"), new Node("200"), 1), list.get(2));
        assertEquals(new Edge(new Node("40"), new Node("20"), 1), list.get(3));
        assertEquals(new Edge(new Node("4"), new Node("2"), 1), list.get(4));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(5));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(6));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(7));
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.get(8));
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.get(9));
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.getTailEdge());
     
    }
    
    @Test
    public void testInsertandGetA() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.insert(0, new Edge(new Node("9"), new Node("9"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        
        assertEquals(new Edge(new Node("9"), new Node("9"), 1), list.get(0));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(1));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(2));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(3));
        assertEquals(new Edge(new Node("9"), new Node("9"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.getTailEdge());
    }
    
    @Test
    public void testInsertandGetB() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.insert(2, new Edge(new Node("9"), new Node("9"), 1));
        
        assertEquals(new Edge(new Node("9"), new Node("9"), 1), list.get(2));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(0));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(1));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(3));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.getTailEdge());
    }
    
    @Test
    public void testInsertandGetC() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.insert(1, new Edge(new Node("9"), new Node("9"), 1));
        
        assertEquals(new Edge(new Node("9"), new Node("9"), 1), list.get(1));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(0));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(2));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(3));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.getTailEdge());
    }
    
    @Test
    public void testRemoveandGetA() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.remove(0);
        
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(0));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(1));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.getTailEdge());
    }
    
    @Test
    public void testRemoveandGetB() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.remove(2);
        
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(0));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(1));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.getTailEdge());
    }
    
    @Test
    public void testRemoveandGetC() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.remove(1);
        
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(0));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(1));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.getTailEdge());
    }
    
    @Test
    public void testSizeandGetA() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.append(new Edge(new Node("1000"), new Node("2000"), 1));
        list.append(new Edge(new Node("10000"), new Node("20000"), 1));
        list.prepend(new Edge(new Node("4"), new Node("2"), 1));
        list.prepend(new Edge(new Node("40"), new Node("20"), 1));
        list.prepend(new Edge(new Node("400"), new Node("200"), 1));
        list.prepend(new Edge(new Node("4000"), new Node("2000"), 1));
        list.prepend(new Edge(new Node("40000"), new Node("20000"), 1));
        
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.get(0));
        assertEquals(new Edge(new Node("4000"), new Node("2000"), 1), list.get(1));
        assertEquals(new Edge(new Node("400"), new Node("200"), 1), list.get(2));
        assertEquals(new Edge(new Node("40"), new Node("20"), 1), list.get(3));
        assertEquals(new Edge(new Node("4"), new Node("2"), 1), list.get(4));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(5));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(6));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(7));
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.get(8));
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.get(9));
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.getTailEdge());
        int expected=10;
        assertEquals(expected,list.size());
    }
    
    @Test
    public void testSizeandGetB() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.append(new Edge(new Node("1000"), new Node("2000"), 1));
        list.append(new Edge(new Node("10000"), new Node("20000"), 1));
        list.prepend(new Edge(new Node("4"), new Node("2"), 1));
        list.prepend(new Edge(new Node("40"), new Node("20"), 1));
        list.prepend(new Edge(new Node("400"), new Node("200"), 1));
        list.prepend(new Edge(new Node("4000"), new Node("2000"), 1));
        list.prepend(new Edge(new Node("40000"), new Node("20000"), 1));
        list.remove(9);
        
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.get(0));
        assertEquals(new Edge(new Node("4000"), new Node("2000"), 1), list.get(1));
        assertEquals(new Edge(new Node("400"), new Node("200"), 1), list.get(2));
        assertEquals(new Edge(new Node("40"), new Node("20"), 1), list.get(3));
        assertEquals(new Edge(new Node("4"), new Node("2"), 1), list.get(4));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(5));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(6));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(7));
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.get(8));
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.getTailEdge());
        int expected=9;
        assertEquals(expected,list.size());
    }
    
    @Test
    public void testSizeandGetC() {
        list.append(new Edge(new Node("1"), new Node("2"), 1));
        list.append(new Edge(new Node("10"), new Node("20"), 1));
        list.append(new Edge(new Node("100"), new Node("200"), 1));
        list.append(new Edge(new Node("1000"), new Node("2000"), 1));
        list.append(new Edge(new Node("10000"), new Node("20000"), 1));
        list.prepend(new Edge(new Node("4"), new Node("2"), 1));
        list.prepend(new Edge(new Node("40"), new Node("20"), 1));
        list.prepend(new Edge(new Node("400"), new Node("200"), 1));
        list.prepend(new Edge(new Node("4000"), new Node("2000"), 1));
        list.prepend(new Edge(new Node("40000"), new Node("20000"), 1));
        list.insert(9, new Edge(new Node("50"), new Node("50"),1));
        
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.get(0));
        assertEquals(new Edge(new Node("4000"), new Node("2000"), 1), list.get(1));
        assertEquals(new Edge(new Node("400"), new Node("200"), 1), list.get(2));
        assertEquals(new Edge(new Node("40"), new Node("20"), 1), list.get(3));
        assertEquals(new Edge(new Node("4"), new Node("2"), 1), list.get(4));
        assertEquals(new Edge(new Node("1"), new Node("2"), 1), list.get(5));
        assertEquals(new Edge(new Node("10"), new Node("20"), 1), list.get(6));
        assertEquals(new Edge(new Node("100"), new Node("200"), 1), list.get(7));
        assertEquals(new Edge(new Node("1000"), new Node("2000"), 1), list.get(8));
        assertEquals(new Edge(new Node("50"), new Node("50"), 1), list.get(9));
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.get(10));
        assertEquals(new Edge(new Node("40000"), new Node("20000"), 1), list.getHeadEdge());
        assertEquals(new Edge(new Node("10000"), new Node("20000"), 1), list.getTailEdge());
        int expected=11;
        assertEquals(expected,list.size());
    }
    
}