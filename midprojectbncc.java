import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class midprojectbncc {
Scanner scan = new Scanner(System.in);
Random jb = new Random();
ArrayList<String> kodekaryawan1 = new ArrayList <>();
ArrayList<String> namakaryawan1 = new ArrayList <>();
ArrayList<String> jeniskelamin1 = new ArrayList <>();
ArrayList<String> jabatan1 = new ArrayList <>();
ArrayList<Double> gajikaryawan1 = new ArrayList<>();
int menu;
String kodekaryawan;
String namakaryawan;
String jeniskelamin;
String jabatan;
double gajikaryawan;

	public void insertdatakaryawan() {
		
		int manager = 0;
		int admin = 0;
		int supervisor = 0;
		
		do {
			System.out.println("Input nama karyawan [>= 3] : ");
			namakaryawan = scan.nextLine();
		}while (namakaryawan.length() <= 3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
			jeniskelamin = scan.nextLine();
		}while (!jeniskelamin.equals("Laki-laki")&& !jeniskelamin.equals("Perempuan"));
		
		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			jabatan = scan.nextLine();
		}while(!jabatan.equals("Manager")&& !jabatan.equals("Supervisor")&& !jabatan.equals("Admin"));
		kodekaryawan = "" + (char) (jb.nextInt(26) + 65) + (char) (jb.nextInt(26)+65) + "-" + jb.nextInt(10) + jb.nextInt(10) + jb.nextInt(10) + jb.nextInt(10);
		System.out.println("Berhasil menambahkan karyawan dengan id "+ kodekaryawan);
		
		if (jabatan.equals("Manager")) {
			gajikaryawan = 8000000;
		} else if (jabatan.equals("Supervisor")) {
			gajikaryawan = 6000000;
		}else if (jabatan.equals("Admin")) {
			gajikaryawan = 4000000;
		}
		 kodekaryawan1.add(kodekaryawan);
		 namakaryawan1.add(namakaryawan);
		 jeniskelamin1.add(jeniskelamin);
		 jabatan1.add(jabatan);
		 gajikaryawan1.add(gajikaryawan);
		 
		    int Manager = 0;
		     int Supervisor = 0;
		     int Admin = 0;
		     
		     for (int i = 0; i < jabatan1.size(); i++) {
		      if (jabatan1.get(i).contains("Manager")) {
		       Manager += 1;
		      }
		      else if (jabatan1.get(i).contains("Supervisor")) {
		       Supervisor += 1;
		      }
		      else if (jabatan1.get(i).contains("Admin")) {
		       Admin += 1;
		      }
		     }
		     
		     if ((Manager - 1)/3 != 0 && (Manager - 1 ) % 3 == 0) {
		      System.out.print("Bonus Sebesar 10% Telah diberikan Kepada Karyawan Dengan ID: ");
		     int temp = (Manager - 1) / 3 * 3;
		     for (int i = 0; i < jabatan1.size(); i++) {
		      if (jabatan1.get(i).contains("Manager") && temp != 0) {
		       System.out.print(kodekaryawan1.get(i) + " ");
		       gajikaryawan1.set(i, gajikaryawan1.get(i)+ gajikaryawan1.get(i) * 0.1);
		       temp--;
		      }
		     }
		     System.out.println();
		     }
		
	}
	public void viewdatakaryawan () {
		sorting();
			    System.out.println("===========================================================================================================================");
			     System.out.printf("| %-4s | %-20s | %-30s | %-20s | %-15s | %-15s |\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			     System.out.println("===========================================================================================================================");
			     for (int i = 0; i < namakaryawan1.size(); i++) {
			     System.out.printf("| %-4s | %-20s | %-30s | %-20s | %-15s | %-15s |\n", i + 1, kodekaryawan1.get(i), namakaryawan1.get(i), jeniskelamin1.get(i), jabatan1.get(i), gajikaryawan1.get(i));
			    }
			    System.out.println("===========================================================================================================================\n");
	}
	
	public void sorting ()  {
		 for (int i = 0; i < namakaryawan1.size() - 1; i++) {
			   for (int j = 0; j < namakaryawan1.size() - i - 1; j++) {
			    if (namakaryawan1.get(j).compareTo(namakaryawan1.get(j + 1)) > 0) {
			     
			     String tempA = kodekaryawan1.get(j);
			     kodekaryawan1.set(j, kodekaryawan1.get(j + 1));
			     kodekaryawan1.set(j + 1, tempA);
			     
			     String tempB = namakaryawan1.get(j);
			     namakaryawan1.set(j, namakaryawan1.get(j + 1));
			     namakaryawan1.set(j + 1, tempB);
			     
			     String tempC = jeniskelamin1.get(j);
			     jeniskelamin1.set(j, jeniskelamin1.get(j + 1));
			     jeniskelamin1.set(j + 1, tempC);
			     
			     String tempD = jabatan1.get(j);
			     jabatan1.set(j, jabatan1.get(j + 1));
			     jabatan1.set(j + 1, tempD);
			     
			     Double tempE = gajikaryawan1.get(j);
			     gajikaryawan1.set(j, gajikaryawan1.get(j + 1));
			     gajikaryawan1.set(j + 1, tempE);
			   }
			  }
			   
			  }
			 
	}
	
	public void updatedatakaryawan() {
		viewdatakaryawan();
		int update;
		do {
			System.out.println("Input angka dari list data yang ingin di update : ");
			try {
				update = scan.nextInt();
			}catch (Exception e) {
				update = -1;
			}scan.nextLine();
		}while (update <1 || update > namakaryawan1.size());
		
		do {
			System.out.println("Input nama karyawan [>= 3] : ");
			namakaryawan = scan.nextLine();
		}while (namakaryawan.length() <= 3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive) : ");
			jeniskelamin = scan.nextLine();
		}while (!jeniskelamin.equals("Laki-laki")&& !jeniskelamin.equals("Perempuan"));
		
		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
			jabatan = scan.nextLine();
		}while(!jabatan.equals("Manager")&& !jabatan.equals("Supervisor")&& !jabatan.equals("Admin"));
		kodekaryawan = "" + (char) (jb.nextInt(26) + 65) + (char) (jb.nextInt(26)+65) + "-" + jb.nextInt(10) + jb.nextInt(10) + jb.nextInt(10) + jb.nextInt(10);
		System.out.println("Berhasil menambahkan karyawan dengan id "+ kodekaryawan);
		
		if (jabatan.equals("Manager")) {
			gajikaryawan = 8000000;
		} else if (jabatan.equals("Supervisor")) {
			gajikaryawan = 6000000;
		}else if (jabatan.equals("Admin")) {
			gajikaryawan = 4000000;
		}
		kodekaryawan1.set(update-1, kodekaryawan);
		namakaryawan1.set(update-1, namakaryawan);
		jeniskelamin1.set(update-1, jeniskelamin);
		jabatan1.set(update-1, jabatan);
	}
	
	public void deletedatakaryawan() {
		viewdatakaryawan();
		int delete;
		do {
			System.out.println("Input angka dari list data yang ingin di delete : ");
			try {
				delete = scan.nextInt();
			}catch (Exception e) {
				delete = -1;
			}scan.nextLine();
		}while (delete < 1 || delete > namakaryawan1.size());
		
		kodekaryawan1.remove(delete-1);
		namakaryawan1.remove(delete-1);
		jeniskelamin1.remove(delete-1);
		jabatan1.remove(delete-1);
		gajikaryawan1.remove(delete-1);
	}
	
	
	public midprojectbncc() {
		do {
		System.out.println("1. Insert data karyawan");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.println("5. Exit");
		System.out.println(">>");
		
		try {
			menu = scan.nextInt();scan.nextLine();
		}catch (Exception e) {
			menu = -1;
		}
		switch (menu) {
		case 1 :
			insertdatakaryawan();
			break;
		case 2 :
			viewdatakaryawan();
			break;
		case 3 :
			updatedatakaryawan();
			break;
		case 4 :
			deletedatakaryawan();
			break;
		}
		
		}while (menu != 5);
		
	}

	public static void main(String[] args) {
		new midprojectbncc();

	}

}
