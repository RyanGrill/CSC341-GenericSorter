import java.util.*;
public class TaskSort<T> implements ITaskSorter<T>
{
	private String dataOrder;
	private String algorithm;
	private Comparator<T> comprtr;
	private T[] arr;
	private long sortStart, sortEnd;
	
	public TaskSort(T[] arr)
	{
		dataOrder = "";
		algorithm = "";
		comprtr = new Comparator<T>(){
			@Override
			public int compare(Object o1, Object o2) 
			{
				return 0;
			}
		};
		this.arr = arr;
		sortStart = 0;
		sortEnd = 0;
	}

	@Override
	public void sort()
	{		
		if(dataOrder.equals("") || algorithm.equals(""))
			return;
		
		if(algorithm.equalsIgnoreCase("insertion-sort"))
			insertionSort();
		else if(algorithm.equalsIgnoreCase("selection-sort"))
			selectionSort();
		else
			return;
	}

	@Override
	public void getData(String dta) 
	{
		dataOrder = dta;
	}

	@Override
	public void setAlgorithm(String alg)
	{		
		algorithm = alg;
	}

	@Override
	public void setComparator(Comparator<T> c) 
	{
		comprtr = c;
	}
	
	public long getExecutionTime()
	{
		return sortEnd - sortStart;
	}
	
	private void insertionSort()
	{
		if(dataOrder.equalsIgnoreCase("ascending"))
			ascendingInsertSort();
		else if(dataOrder.equalsIgnoreCase("descending"))
			descendingInsertSort();
		else
			return;
	}
	
	private void descendingInsertSort() 
	{
		sortStart = System.nanoTime();
		int n = arr.length; 
        for (int i = 1; i < n; i++) 
        { 
        	T key = arr[i]; 
        	int j = i - 1;
        	while (j >= 0 && comprtr.compare(arr[j], key) < 0) 
        	{ 
        		arr[j + 1] = arr[j]; 
        		j--; 
        	}
        	arr[j + 1] = key;
        }
        sortEnd = System.nanoTime(); 
	}

	private void ascendingInsertSort()
	{
		sortStart = System.nanoTime();
		int n = arr.length; 
        for (int i = 1; i < n; i++) 
        { 
        	T key = arr[i]; 
        	int j = i - 1;
        	while (j >= 0 && comprtr.compare(arr[j], key) > 0) 
        	{ 
        		arr[j + 1] = arr[j]; 
        		j--; 
        	}
        	arr[j + 1] = key;
        	sortEnd = System.nanoTime();
        }
	}
	
	private void selectionSort() 
	{
		if(dataOrder.equalsIgnoreCase("ascending"))
			ascendingSelectSort();
		else if(dataOrder.equalsIgnoreCase("ascending"))
			descendingSelectSort();
		else
			return;	
	}

	private void ascendingSelectSort() 
	{
		sortStart = System.nanoTime();
		int n = arr.length; 

        for (int i = 0; i < n-1; i++) 
        { 
            int min_index = i; 
            for (int j = i+1; j < n; j++) 
                if (comprtr.compare(arr[j], arr[min_index]) > 0) 
                    min_index = j; 
  
            T temp = arr[min_index]; 
            arr[min_index] = arr[i]; 
            arr[i] = temp; 
        } 
		sortEnd = System.nanoTime();
	}
	
	private void descendingSelectSort() 
	{
		sortStart = System.nanoTime();
		int n = arr.length; 

        for (int i = 0; i < n-1; i++) 
        { 
            int min_index = i; 
            for (int j = i+1; j < n; j++) 
                if (comprtr.compare(arr[j], arr[min_index]) < 0) 
                    min_index = j; 
  
            T temp = arr[min_index]; 
            arr[min_index] = arr[i]; 
            arr[i] = temp; 
        } 
		sortEnd = System.nanoTime();
	}
}
