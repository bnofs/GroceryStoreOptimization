
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Store {	
	public Node entrance;
	//Make this not hardcoded by reading the length of the first row outside of loop
	public Node[][] storeMap = new Node[24][50];

	
	public Store(String file_name) {
		File file = new File(file_name);
		Scanner in;
		try {
			in = new Scanner(file);
			
			int i = 0;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				
				for (int j = 0; j < line.length(); j++) {
					Node node = new Node(i,j);
					if (line.charAt(j) == 'E') {
						this.entrance = new Node(i, j);
					}  else if (line.charAt(j) == '#') {
						node.traversable = false;
					}
					storeMap[i][j] = node;
				}
				i++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void print(){
		for(int i =0; i<storeMap.length;i++){
			for(int j=0; j<storeMap[i].length;j++){
				if(!storeMap[i][j].traversable){
					System.out.print("#");
				}
				else if (entrance.row == i && entrance.col == j){
					System.out.print("E");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
