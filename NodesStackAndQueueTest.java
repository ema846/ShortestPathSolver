package nz.ac.auckland.softeng281.a4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class NodesStackAndQueueTest {

    NodesStackAndQueue stack;
    
    @Before
    public void setUp() {
        stack = new NodesStackAndQueue();
    }

    @Test
    public void isEmptyEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmptyNotEmpty() {
        stack.append(new Node("4"));
        assertFalse(stack.isEmpty());
    }
    
    @Test 
    public void testPushandAppendA() {
    	stack.push(new Node("1"));
    	stack.push(new Node("2"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	
    	assertEquals(stack.getList().get(0),new Node("4"));
    	assertEquals(stack.getList().get(1),new Node("3"));
    	assertEquals(stack.getList().get(2),new Node("1"));
    	assertEquals(stack.getList().get(3),new Node("2")); 
    }
    
    @Test 
    public void testPushandAppendB() {
    	stack.push(new Node("1"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	stack.push(new Node("2"));
    	stack.append(new Node("10"));
    	stack.push(new Node("20"));
    	
    	assertEquals(stack.getList().get(0),new Node("10"));
    	assertEquals(stack.getList().get(1),new Node("4"));
    	assertEquals(stack.getList().get(2),new Node("3"));
    	assertEquals(stack.getList().get(3),new Node("1")); 
    	assertEquals(stack.getList().get(4),new Node("2"));
    	assertEquals(stack.getList().get(5),new Node("20")); 
    	
    }
    
    @Test 
    public void testPushandAppendC() {
    	stack.push(new Node("1"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	stack.push(new Node("2"));
    	stack.append(new Node("10"));
    	stack.push(new Node("20"));
    	stack.push(new Node("9"));
    	stack.append(new Node("22"));
    	stack.push(new Node("33"));
    	
    	assertEquals(stack.getList().get(0),new Node("22"));
    	assertEquals(stack.getList().get(1),new Node("10"));
    	assertEquals(stack.getList().get(2),new Node("4"));
    	assertEquals(stack.getList().get(3),new Node("3")); 
    	assertEquals(stack.getList().get(4),new Node("1"));
    	assertEquals(stack.getList().get(5),new Node("2")); 
    	assertEquals(stack.getList().get(6),new Node("20")); 
    	assertEquals(stack.getList().get(7),new Node("9"));
    	assertEquals(stack.getList().get(8),new Node("33"));
    	
    }
    
    @Test 
    public void testPushandAppendD() {
    	stack.push(new Node("1"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	stack.push(new Node("2"));
    	stack.append(new Node("10"));
    	stack.push(new Node("20"));
    	stack.push(new Node("9"));
    	stack.append(new Node("22"));
    	stack.push(new Node("33"));
    	stack.push(new Node("123"));
    	stack.append(new Node("345"));
    	stack.push(new Node("456"));
    	
    	assertEquals(stack.getList().get(0),new Node("345"));
    	assertEquals(stack.getList().get(1),new Node("22"));
    	assertEquals(stack.getList().get(2),new Node("10"));
    	assertEquals(stack.getList().get(3),new Node("4")); 
    	assertEquals(stack.getList().get(4),new Node("3"));
    	assertEquals(stack.getList().get(5),new Node("1")); 
    	assertEquals(stack.getList().get(6),new Node("2")); 
    	assertEquals(stack.getList().get(7),new Node("20"));
    	assertEquals(stack.getList().get(8),new Node("9"));
    	assertEquals(stack.getList().get(9),new Node("33")); 
    	assertEquals(stack.getList().get(10),new Node("123"));
    	assertEquals(stack.getList().get(11),new Node("456"));
    	
    }
    
    @Test 
    public void testPopA() {
    	stack.push(new Node("1"));
    	stack.push(new Node("2"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	
    	Node expected = stack.pop();
    	assertEquals(new Node("2"),expected);
    	
    	assertEquals(stack.getList().get(0),new Node("4"));
    	assertEquals(stack.getList().get(1),new Node("3"));
    	assertEquals(stack.getList().get(2),new Node("1")); 
    }
    
    @Test 
    public void testPopB() {
    	stack.push(new Node("1"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	stack.push(new Node("2"));
    	stack.append(new Node("10"));
    	stack.push(new Node("20"));
    	stack.push(new Node("9"));
    	stack.append(new Node("22"));
    	stack.push(new Node("33"));
    	
    	Node expected = stack.pop();
    	assertEquals(new Node("33"),expected);
    	
    	assertEquals(stack.getList().get(0),new Node("22"));
    	assertEquals(stack.getList().get(1),new Node("10"));
    	assertEquals(stack.getList().get(2),new Node("4"));
    	assertEquals(stack.getList().get(3),new Node("3")); 
    	assertEquals(stack.getList().get(4),new Node("1"));
    	assertEquals(stack.getList().get(5),new Node("2")); 
    	assertEquals(stack.getList().get(6),new Node("20")); 
    	assertEquals(stack.getList().get(7),new Node("9"));
    	
    }
    
    @Test 
    public void testPeekA() {
    	stack.push(new Node("1"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	stack.push(new Node("2"));
    	stack.append(new Node("10"));
    	stack.push(new Node("20"));
    	
    	Node expected = stack.peek();
    	assertEquals(new Node("20"),expected);
    	
    	assertEquals(stack.getList().get(0),new Node("10"));
    	assertEquals(stack.getList().get(1),new Node("4"));
    	assertEquals(stack.getList().get(2),new Node("3"));
    	assertEquals(stack.getList().get(3),new Node("1")); 
    	assertEquals(stack.getList().get(4),new Node("2"));
    	assertEquals(stack.getList().get(5),new Node("20")); 
    	
    }
    
    @Test 
    public void testPeekB() {
    	stack.push(new Node("1"));
    	stack.append(new Node("3"));
    	stack.append(new Node("4"));
    	stack.push(new Node("2"));
    	stack.append(new Node("10"));
    	stack.push(new Node("20"));
    	stack.push(new Node("9"));
    	stack.append(new Node("22"));
    	stack.push(new Node("33"));
    	stack.push(new Node("123"));
    	stack.append(new Node("345"));
    	stack.push(new Node("456"));
    	
    	Node expected = stack.peek();
    	assertEquals(new Node("456"),expected);
    	
    	assertEquals(stack.getList().get(0),new Node("345"));
    	assertEquals(stack.getList().get(1),new Node("22"));
    	assertEquals(stack.getList().get(2),new Node("10"));
    	assertEquals(stack.getList().get(3),new Node("4")); 
    	assertEquals(stack.getList().get(4),new Node("3"));
    	assertEquals(stack.getList().get(5),new Node("1")); 
    	assertEquals(stack.getList().get(6),new Node("2")); 
    	assertEquals(stack.getList().get(7),new Node("20"));
    	assertEquals(stack.getList().get(8),new Node("9"));
    	assertEquals(stack.getList().get(9),new Node("33")); 
    	assertEquals(stack.getList().get(10),new Node("123"));
    	assertEquals(stack.getList().get(11),new Node("456"));
    	
    }
  
    
}