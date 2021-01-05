package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * Mục đích: Toa lop truong hoc quan ly cac nghiep vu lien quan
 * Người tạo: Bui Quoc Trieu
 * Ngày tạo: 22/4/2020
 * Version: 1.0
 * */

public class TruongHoc {
	// 1. ATTRIBUTES
	private DanhSachThanhVien objDSThanhVien;
	private ArrayList<GiaoVien> dsGiaoVien;
	private ArrayList<HocSinh> dsHocSinh;
	public static int diem5 = 5;
	public static int diem7 = 7;
	public static int diem8 = 8;
	public static int diem9 = 9;

	// 2 GET, SET METHODS
	public DanhSachThanhVien getObjDSThanhVien() {
		return objDSThanhVien;
	}

	public void setObjDSThanhVien(DanhSachThanhVien objDSThanhVien) {
		this.objDSThanhVien = objDSThanhVien;
	}

	// 3. CONSTRUCTORS

	public TruongHoc() {
		dsGiaoVien = new ArrayList<GiaoVien>();
		dsHocSinh = new ArrayList<HocSinh>();
	}

	// 4. INPUT, OUTPUT METHODS

	public void xuat() {

	}

	public void xuatDSTV() {
		this.objDSThanhVien.xuat();
	}

	// 5. BUSINESS METHODS

	public void init() {
		this.objDSThanhVien.tinhThamNien();
		this.objDSThanhVien.tinhDTB();
		xepLoaiHS();
	}

	public void taoDuLieu() {
		this.objDSThanhVien = new DanhSachThanhVien();
		this.objDSThanhVien.taoDuLieu();
	}

	public ArrayList<GiaoVien> layDSGiaoVien() {
		ArrayList<GiaoVien> listGV = new ArrayList<GiaoVien>();
		for (ThanhVien tv : this.objDSThanhVien.getListThanhVien()) {
			if (tv instanceof GiaoVien) {
				listGV.add((GiaoVien) tv);
			}
		}
		return listGV;
	}

	public ArrayList<HocSinh> layDSHocSinh() {
		ArrayList<HocSinh> listHS = new ArrayList<HocSinh>();
		for (ThanhVien tv : this.objDSThanhVien.getListThanhVien()) {
			if (tv instanceof HocSinh) {
				listHS.add((HocSinh) tv);
			}
		}
		return listHS;
	}

	public ArrayList<GiaoVien> lietKeGVThamNienMax() {
		ArrayList<GiaoVien> listGVThamNien = new ArrayList<GiaoVien>();
		// 1. Tìm Giao Vien đầu tiên trong ds nhan sự
		GiaoVien gv = null;// Chưa tìm thấy
		int indexMax = 0;
		for (ThanhVien tv : objDSThanhVien.getListThanhVien()) {
			indexMax++;
			if (tv instanceof GiaoVien) {
				gv = (GiaoVien) tv;
				break;
			}
		}
		// 2. Nếu có, thì cho TV vừa tìm trong bước 1 la giao vien có tham nien cao nhất
		if (gv != null) {
			// 3. Duỵet DS từ vị trí vừa tìm ở bước 2 và tìm GV có tham nien thật sự cao
			// nhất
			for (int i = indexMax - 1; i < objDSThanhVien.getListThanhVien().size(); i++) {
				ThanhVien current = objDSThanhVien.getListThanhVien().get(i);
				if (current instanceof GiaoVien) {
					if (((GiaoVien) current).getThamNien() > ((GiaoVien) gv).getThamNien()) {
						gv = (GiaoVien) current;
						indexMax++;
					}
				}
			}
			// 4. Duỵet lại DS và so sánh lương của thanh vien đang duyệt với NGV max thực
			// sự ở
			// bước 3 --> them vào danh sách
			for (int i = indexMax - 1; i < objDSThanhVien.getListThanhVien().size(); i++) {
				ThanhVien current = objDSThanhVien.getListThanhVien().get(i);
				if (current instanceof GiaoVien) {
					if (((GiaoVien) current).getThamNien() == ((GiaoVien) gv).getThamNien()) {
						listGVThamNien.add((GiaoVien) current);
					}
				}
			}
		}

		return listGVThamNien;
	}

	public ArrayList<GiaoVien> lietKeGvThoaDk() {
		ArrayList<GiaoVien> listGvThoaDk = new ArrayList<GiaoVien>();

		ArrayList<GiaoVien> listGv = layDSGiaoVien();
		for (int i = 0; i < listGv.size(); i++) {
			// Tim giao vien khoi tu nhien
			GiaoVien current = listGv.get(i);
			if (current.getChuyenMon() == 1 && current.getThamNien() > 5) {
				listGvThoaDk.add(current);
			}

		}
		return listGvThoaDk;
	}

	public float timDTBMax() {
		float DTBMax = 0;
		ArrayList<HocSinh> listHS = layDSHocSinh();
		float tam = listHS.get(0).getDiemTB();
		for (int i = 0; i < listHS.size(); i++) {
			// Tim diem trung binh cao nhat
			HocSinh current = listHS.get(i);
			if (current.getDiemTB() > tam) {
				DTBMax = current.getDiemTB();
			}
		}
		return DTBMax;
	}

	public ArrayList<HocSinh> timHocSinhDiemMax() {
		ArrayList<HocSinh> listHSthoadk = new ArrayList<HocSinh>();
		ArrayList<HocSinh> listHS = layDSHocSinh();
		float DTBMax = timDTBMax();
		for (int i = 0; i < listHS.size(); i++) {
			// Tim Hoc Sinh co diem TB cao nhat
			HocSinh current = listHS.get(i);
			if (current.getDiemTB() == DTBMax) {
				listHSthoadk.add(current);
			}

		}
		return listHSthoadk;

	}

	public void xepLoaiHS() {
		for (ThanhVien tv : objDSThanhVien.getListThanhVien()) {
			if (tv instanceof HocSinh) {
			float currentDTB = ((HocSinh) tv).diemTB;
			if (currentDTB < diem5) {
				((HocSinh) tv).xepLoai  = "Yeu";
			} else if (currentDTB >= diem5 && currentDTB < diem7) {
				((HocSinh) tv).xepLoai  = "Trung Binh";
			} else if (currentDTB >= diem7 && currentDTB < diem8) {
				((HocSinh) tv).xepLoai  = "Kha";
			} else if (currentDTB >= diem8 && currentDTB < diem9) {
				((HocSinh) tv).xepLoai  = "Gioi";
			} else {
				((HocSinh) tv).xepLoai  = "Xuat Sac";
			}
		}
		}
	}
	
	public static void quickSort_DTB(ArrayList<HocSinh> listHsSapXep, int left, int right) {
		int i, j;
		float x = listHsSapXep.get((left+right)/2).getDiemTB();
		i = left;
		j = right;
		do {
			// phan hoach
			while (listHsSapXep.get(i).getDiemTB()  < x) {
				// chay nua ben trai
				i++;
			}
			while (x>listHsSapXep.get(j).getDiemTB()) {
				//chay nua ben phai
				j--;
			}
			if (i <= j) {
				// hoan vi neu sai vi tri
				Collections.swap(listHsSapXep, i, j);
				i++;
				j--;
			}
		} while (i < j);
		if (left < j) {
			quickSort_DTB(listHsSapXep, left, j);
			// de qui doan ben trai
		}

		if (i < right) {
			quickSort_DTB(listHsSapXep, i, right);
		}
		// de qui cac doan ben phai
//		return listHsSapXep;

	}
	
	
	
	
	
}
