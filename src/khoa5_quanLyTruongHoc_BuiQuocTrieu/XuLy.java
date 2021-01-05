package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.util.ArrayList;
//import java.util.Scanner;

public class XuLy {

	public static void main(String[] args) {
		TruongHoc th = new TruongHoc();
		th.taoDuLieu();
		
//Scanner scan = new Scanner(System.in);
		th.init();
		
		th.xuatDSTV();
		
		System.out.println("******* Danh sách Giao vien có tham nien cao nhất ********");
		ArrayList<GiaoVien> listGV = th.lietKeGVThamNienMax();
		for(GiaoVien gv : listGV) {
			gv.xuat();
		}
		
		System.out.println("******* Danh sách Giao vien có tham nien >5 va thuoc khoi Tu Nhien ********");
		ArrayList<GiaoVien> listGvThoaDk = th.lietKeGvThoaDk();
		for(GiaoVien gv : listGvThoaDk) {
			gv.xuat();
		}
		
		
		float DTBmax = th.timDTBMax();
		System.out.println("******* Diem Trung Binh Lon Nhat cua Hoc Sinh = "+ DTBmax +" ********");

		
		System.out.println("******* Danh sách Hoc Sinh co diem trung binh cao nhất ********");
		ArrayList<HocSinh> listHSMax = th.timHocSinhDiemMax();
		for(HocSinh hs : listHSMax) {
			hs.xuat();
		}
		
		System.out.println("******* Danh sách Hoc Sinh da sap xep theo DTB ********");
		ArrayList<HocSinh> listHsSapXep = th.layDSHocSinh();
		
		TruongHoc.quickSort_DTB(listHsSapXep, 0, listHsSapXep.size());
		
	}

}
