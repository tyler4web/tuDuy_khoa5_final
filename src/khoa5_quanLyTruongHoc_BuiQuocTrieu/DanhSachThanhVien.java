package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Mục đích: Tao danh sach giao vien va business method giao vien
 * Người tạo: Bui Quoc Trieu
 * Ngày tạo: 22/4/2020
 * Version: 1.0
 * */

public class DanhSachThanhVien implements NhapXuat {

	// 1. ATTRIBUTES
	private ArrayList<ThanhVien> listThanhVien;
	final static int soNam5 = 5;

	// 2 GET, SET METHODS

	public ArrayList<ThanhVien> getListThanhVien() {
		return listThanhVien;
	}

	public void setListThanhVien(ArrayList<ThanhVien> listThanhVien) {
		this.listThanhVien = listThanhVien;
	}

	// 3. CONSTRUCTORS
	public DanhSachThanhVien(ArrayList<ThanhVien> listThanhVien) {
		super();
		this.listThanhVien = listThanhVien;
	}

	// 3. Constructors
	public DanhSachThanhVien() {
		this.listThanhVien = new ArrayList<ThanhVien>();
	}

	// 4. INPUT, OUTPUT METHODS
	private void inMenu() {
		System.out.println("Vui lòng chọn theo menu:");
		System.out.println("1. Nhập thông tin Giáo Viên");
		System.out.println("2. Nhập thông tin Học Sinh");
		System.out.println("0. Thoát");
	}

	public void nhap(Scanner scan) {
		boolean flag = true;
		ThanhVien tv;
		do {
			inMenu();
			System.out.print("Mời chọn >>");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 0:
				flag = false;
				break;
			case 1:
				tv = new GiaoVien();
				tv.nhap(scan);
				this.them(tv);
				break;
			case 2:
				tv = new HocSinh();
				tv.nhap(scan);
				this.them(tv);
				break;
			default:
				System.out.println("Vui lòng nhập từ 0 - 2");
			}
		} while (flag);
	}

	public void xuat() {
		for (ThanhVien tv : this.listThanhVien) {
			tv.xuat();
		}
	}

	public void them(ThanhVien tv) {
		this.listThanhVien.add(tv);
	}

	// 5. BUSINESS METHODS
	

	
	public void tinhThamNien() {
		for(ThanhVien tv: this.listThanhVien) {
			if( tv instanceof GiaoVien) {
				((GiaoVien) tv).tinhThamNien();
			}
		}
	}
	
	public void tinhDTB() {
		for(ThanhVien tv: this.listThanhVien) {
			if( tv instanceof HocSinh) {
				((HocSinh) tv).tinhDiemTB();
			}
		}
	}

	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSTV.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				ThanhVien tv;
				// Kiểm tra là giao vien hay Hoc Sinh
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {
					tv = new GiaoVien();
					((GiaoVien) tv).setChuyenMon(Integer.parseInt(listInfo[4]));
					((GiaoVien) tv).setFirstYearTeach(Integer.parseInt(listInfo[5]));
				} else {
					tv = new HocSinh();
					((HocSinh) tv).setDiemToan(Integer.parseInt(listInfo[4]));
					((HocSinh) tv).setDiemVan(Integer.parseInt(listInfo[5]));
					((HocSinh) tv).setDiemNgoaiNgu(Integer.parseInt(listInfo[6]));
				}
				// Tạo dữ liệu cho mỗi thanh vien
				tv.setHoTen(listInfo[0]);
				tv.setNamSinh(Integer.parseInt(listInfo[1]));
				tv.setNoiSinh(listInfo[2]);
				tv.setDiaChi(listInfo[3]);
				
				
				// Thêm thanh vien vào list
				this.listThanhVien.add(tv);
			}
			reader.close();// Đóng tập tin
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
