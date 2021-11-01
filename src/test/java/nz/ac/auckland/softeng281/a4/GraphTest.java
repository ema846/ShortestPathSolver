package nz.ac.auckland.softeng281.a4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Enclosed.class)
public class GraphTest {

    public static class GraphUnitTest {
        Graph graph;

        @Before
        public void setUp() throws Exception {
            List<String> edges = Arrays.asList("1,2", "2,3", "2,4", "4,2");
            List<String> weights = Arrays.asList("10", "20", "30", "20");
            graph = new Graph(edges, weights);
        }


       @Test
        public void testFindNode() {
            assertTrue(graph.isNodeInGraph(new Node("1")));
            assertTrue(graph.isNodeInGraph(new Node("2")));
            assertTrue(graph.isNodeInGraph(new Node("3")));
            assertTrue(graph.isNodeInGraph(new Node("4")));
            assertFalse(graph.isNodeInGraph(new Node("5")));
        }
       
       @Test
       public void testIsNodeInGraphA() {
    	   List<String> edges = Arrays.asList("1,1");
           List<String> weights = Arrays.asList("10");
           graph = new Graph(edges, weights);
           assertTrue(graph.isNodeInGraph(new Node("1")));
       }
       
       @Test
       public void testIsNodeInGraphB() {
    	   List<String> edges = Arrays.asList("1,2", "2,1");
           List<String> weights = Arrays.asList("10", "20");
           graph = new Graph(edges, weights);
           assertTrue(graph.isNodeInGraph(new Node("1")));
           assertTrue(graph.isNodeInGraph(new Node("2")));
       }

        @Test
        public void testShortestPath() {
            List<String> edges = Arrays.asList("1,2", "2,3", "3,4", "4,5");
            List<String> weights = Arrays.asList("10", "20", "30", "20");
            graph = new Graph(edges, weights);
            Path path = new Path(80, new Node("1"), new Node("2"), new Node("3"), new Node("4"), new Node("5"));
            assertEquals(path, graph.computeShortestPath(new Node("1"), new Node("5")));
        }
        
        @Test
        public void testShortestPathA() {
            List<String> edges = Arrays.asList("1,2", "2,3", "3,4", "1,1");
            List<String> weights = Arrays.asList("10", "20", "30", "50");
            graph = new Graph(edges, weights);
            Path path = new Path(0, new Node("1"), new Node("1"));
            assertEquals(path, graph.computeShortestPath(new Node("1"), new Node("1")));
        }

    }

    public static class GraphSystemTest {

        ByteArrayOutputStream myOut;
        PrintStream origOut;

        @Before
        public void setUp() {
            origOut = System.out;
            myOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(myOut));
        }

        @After
        public void tearDown() {
            System.setOut(origOut);
            if (myOut.toString().length() > 1) {
                System.out.println(System.lineSeparator() + "the System.out.print was :" + System.lineSeparator()
                        + myOut.toString());
            }
        }

        private void runTest(String fileName, String command) {
            GraphUI.scanner = new Scanner("open " + fileName + System.getProperty("line.separator") + command
                    + System.getProperty("line.separator") + "exit" + System.getProperty("line.separator"));
            GraphControl controller = new GraphControl();
            controller.execute();
        }
        
        @Test
        public void testSearchWeightA() {
        	runTest("a.txt", "search 1 3");
             assertTrue(myOut.toString().contains("Given the edge from source 1 target 3 has weight: 5"));
        }
        
        @Test
        public void testSearchWeightB() {
        	runTest("a.txt", "search 0 0");
             assertTrue(myOut.toString().contains("Given the edge from source 0 target 0 has weight: 1"));
        }
        
        @Test
        public void testSearchWeightC() {
        	runTest("a.txt", "search 2 5");
             assertTrue(myOut.toString().contains("Given the edge from source 2 target 5 has weight: 1"));
        }
        
        @Test
        public void testSearchWeightD() {
        	runTest("a.txt", "search 0 2");
             assertTrue(myOut.toString().contains("There is no such edge with source : Node{value='0'} target: Node{value='2'}"));
        }
        
        @Test
        public void testSearchEdgeByWeightA() {
            runTest("a.txt", "search 5");
            assertTrue(myOut.toString().contains("The edge searched having weight 5 is: 1-->3"));
        }
        
        @Test
        public void testSearchEdgeByWeightB() {
            runTest("a.txt", "search 3");
            assertTrue(myOut.toString().contains("The edge searched having weight 3 is: 1-->1"));
        }
        
        @Test
        public void testSearchEdgeByWeightC() {
            runTest("a.txt", "search 5");
            assertTrue(myOut.toString().contains("The edge searched having weight 5 is: 1-->3"));
        }
        
        @Test
        public void testSearchEdgeByWeightD() {
            runTest("g7.txt", "search 5");
            assertTrue(myOut.toString().contains("The edge searched having weight 5 is: 4-->5"));
        }
        
        @Test
        public void testSearchEdgeByWeightE() {
            runTest("a.txt", "search 2");
            assertTrue(myOut.toString().contains("The edge searched having weight 2 is: 0-->1"));
        }
        
        @Test
        public void testSearchEdgeByWeightF() {
            runTest("a.txt", "search 4");
            assertTrue(myOut.toString().contains("The edge searched having weight 4 is: 1-->2"));
        }
        
        @Test
        public void testSearchEdgeByWeightG() {
            runTest("a.txt", "search 0");
            assertTrue(myOut.toString().contains("There is no such edge with weight: 0"));
        }
        
        @Test
        public void testSearchEdgeByWeightH() {
            runTest("a.txt", "search 321");
            assertTrue(myOut.toString().contains("There is no such edge with weight: 321"));
        }
        
        @Test
        public void testSearchEdgeByWeightAg7() {
            runTest("g7.txt", "search 3");
            assertTrue(myOut.toString().contains("The edge searched having weight 3 is: 7-->2"));
        }
        
        @Test
        public void testSearchEdgeByWeightBg7() {
            runTest("g7.txt", "search 6");
            assertTrue(myOut.toString().contains("The edge searched having weight 6 is: 2-->3"));
        }
        
        @Test
        public void testSearchEdgeByWeightCg7() {
            runTest("g7.txt", "search 2");
            assertTrue(myOut.toString().contains("The edge searched having weight 2 is: 5-->6"));
        }
        
        @Test
        public void testSearchEdgeByWeightDg7() {
            runTest("g7.txt", "search 4");
            assertTrue(myOut.toString().contains("The edge searched having weight 4 is: 7-->4"));
        }
        
        @Test
        public void testShortestPathA() {
            runTest("a.txt", "path 5 1");
            assertTrue(myOut.toString().contains("The shortest path is: 5 -> 4 -> 1 cost: 4"));
        }
        
        @Test
        public void testShortestPathB() {
            runTest("a.txt", "path 0 0");
            assertTrue(myOut.toString().contains("The shortest path is: 0 -> 0 cost: 0"));
        }
        
        @Test
        public void testShortestPathC() {
            runTest("a.txt", "path 0 3");
            assertTrue(myOut.toString().contains("The shortest path is: 0 -> 1 -> 3 cost: 7"));
        }
        
        @Test
        public void testShortestPathD() {
            runTest("a.txt", "path 4 4");
            assertTrue(myOut.toString().contains("The shortest path is: 4 -> 4 cost: 0"));
        }
        
        @Test
        public void testShortestPathE() {
            runTest("g7.txt", "path 7 1");
            assertTrue(myOut.toString().contains("The shortest path is: 7 -> 5 -> 6 -> 1 cost: 11"));
        }
        
        @Test
        public void testShortestPathF() {
            runTest("g7.txt", "path 7 1");
            assertTrue(myOut.toString().contains("The shortest path is: 7 -> 5 -> 6 -> 1 cost: 11"));
        }

    }


}