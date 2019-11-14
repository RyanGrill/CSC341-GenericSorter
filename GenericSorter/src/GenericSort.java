import java.util.*;
public class GenericSort 
{
	public static void main(String[] args) 
	{
		TaskSort <Integer> task = new TaskSort <Integer>(new Integer[]{2, 5, 87, 223, 1, 45});
		task.getData("descending");
		task.setAlgorithm("insertion-sort");
		task.setComparator(new Comparator<Integer>(){
			public int compare(Integer num1, Integer num2)
			{ 
				return num1 - num2;
			}
		});
		task.sort();
		System.out.println("Sort1: " + task.getExecutionTime());

		Student[] stuArr = new Student[]{new Student("Ryan", 101), new Student("Nick", 802), new Student("James", 435)}; 
		
		TaskSort<Student> task2 = new TaskSort <Student>(stuArr);
		task2.getData("ascending");
		task2.setAlgorithm("selection-sort");
		task2.setComparator(new Comparator<Student>(){
			public int compare(Student s1, Student s2)
			{ 
				return s1.getStuNum() - s2.getStuNum();
			}
		});
		task2.sort();
		System.out.println("Sort1: " + task2.getExecutionTime());
	}
}

class Student
{
	private String name;
	private int stuNum;
	
	public Student(String name, int stuNum)
	{
		this.name = name;
		this.stuNum = stuNum;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getStuNum() 
	{
		return stuNum;
	}
	public void setStuNum(int stuNum) 
	{
		this.stuNum = stuNum;
	}	
}