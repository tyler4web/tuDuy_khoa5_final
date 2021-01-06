package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public static void main(String[] args) {
		TruongHoc th = new TruongHoc();
		th.taoDuLieu();
		Scanner scan = new Scanner(System.in);
//		th.getObjDSThanhVien().inMenu();
		th.getObjDSThanhVien().nhap(scan);;	
		

		th.init();
		
		System.out.println("******* Danh sách Thanh Vien trong truong (Giao Vien va Hoc Sinh) ********");
		th.xuatDSTV();
		
		System.out.println("\n");
		System.out.println("******* Danh sách Giao vien có tham nien cao nhất ********");
		ArrayList<GiaoVien> listGV = th.lietKeGVThamNienMax();
		for(GiaoVien gv : listGV) {
			gv.xuat();
		}
		
		System.out.println("\n");
		System.out.println("******* Danh sách Giao vien có tham nien >5 va thuoc khoi Tu Nhien ********");
		ArrayList<GiaoVien> listGvThoaDk = th.lietKeGvThoaDk();
		for(GiaoVien gv : listGvThoaDk) {
			gv.xuat();
		}
		
		System.out.println("\n");
		float DTBmax = th.timDTBMax();
		System.out.println("******* Diem Trung Binh Lon Nhat cua Hoc Sinh = "+ DTBmax +" ********");

		System.out.println("\n");
		System.out.println("******* Danh sách Hoc Sinh co diem trung binh cao nhất ********");
		ArrayList<HocSinh> listHSMax = th.timHocSinhDiemMax();
		for(HocSinh hs : listHSMax) {
			hs.xuat();
		}
		System.out.println("\n");
		System.out.println("******* Danh sách Hoc Sinh da sap xep theo DTB ********");
		ArrayList<HocSinh> listHsSortDTB = th.layDSHocSinh();
		
		TruongHoc.quickSort_DTB(listHsSortDTB, 0, listHsSortDTB.size()-1);
		for(HocSinh hs : listHsSortDTB) {
			hs.xuat();
		}
		
		System.out.println("\n");
		System.out.println("******* Danh sách Hoc Sinh da sap xep theo thu tu ABC ********");
		ArrayList<HocSinh> listHsSortABC = th.layDSHocSinh();
		
		TruongHoc.bubbleSort_tenHS(listHsSortABC);
		for(HocSinh hs : listHsSortABC) {
			hs.xuat();
		}
	}
	

}
	


