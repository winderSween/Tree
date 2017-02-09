import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BinaryTrees.BinarySearchTree;
import BinaryTrees.BinaryTree;
import BinaryTrees.TreeIterator;
import BinaryTrees.TreeNode;

/**1
 * 
 * @author huangshengwei
 * @studentID 1475765
 */
public class Project4 {
	public static void main(String []args){
		try{
			BinarySearchTree<StudentGPA> order=new BinarySearchTree<>();
			
			Scanner inputFile=new Scanner(new File("students.in"));
			String b=inputFile.nextLine();
			while(inputFile.hasNextLine()){
				Scanner other=new Scanner(b);
				int id=other.nextInt();
				String name=other.next();
				double gpa=other.nextDouble();				
				if(!other.hasNext()){
					StudentGPA order1=new StudentGPA(id,name,gpa);
					order.insert(order1);
				}
				else{
					String ad=other.next();
					GraduateStudentGPA order2=new GraduateStudentGPA(id,name,gpa,ad);
					order.insert(order2);
				}
				if(!inputFile.hasNext()){
					break;
				}
				else{
					b=inputFile.nextLine();
				}			
			}
		TreeIterator<StudentGPA> a=(TreeIterator<StudentGPA>)order.iterator();
		a.setInorder();
		ArrayList<StudentGPA> myArrayList=new ArrayList<>();
		while(a.hasNext()){
			myArrayList.add(a.next());			
		}
//		BinaryTree<StudentGPA> tree2 = readTree(myArrayList);
//		 TreeIterator<StudentGPA> bb=(TreeIterator<StudentGPA>)
//		 tree2.iterator();
//		 bb.printInorder();
		inputFile.close();
		}
		catch(IOException e){
			System.err.println("IOError!!!\n" + e);
		    System.exit(9);
		}		
	}		
	protected static BinaryTree<StudentGPA> readTree(ArrayList<StudentGPA> myArray){
		return readTreeAgain(myArray,myArray.size()-1);
	}
	protected static BinaryTree<StudentGPA> readTreeAgain(ArrayList<StudentGPA> myArray,int n){
		BinaryTree<StudentGPA> treeNode=new BinaryTree<>();
		if(n>0){
			treeNode.setRootItem(myArray.remove(0));
			treeNode.attachLeftSubtree(readTreeAgain(myArray,(n/2)));
			treeNode.attachRightSubtree(readTreeAgain(myArray,(n-1)/2));	
			}
		return treeNode;
		
	}
}
