import java.util.*;
interface ITaskSorter<T>
{
	public void sort();
	public void getData(String s);
	public void setAlgorithm(String s);
	public void setComparator(Comparator<T> c);
	public long getExecutionTime();
}


