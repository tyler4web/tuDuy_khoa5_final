package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.time.LocalDate;
import java.util.Scanner;

/*
 * Mục đích: class để lưu trữ và xử lý lien quan Giao Vien
 * Người tạo: Bui Quoc Trieu
 * Ngày tạo: 04/01/2020
 * Version: 1.0
 * */
public class GiaoVien extends ThanhVien {
	// 1. Attributes
	protected int firstYearTeach;
	protected int chuyenMon;
	protected int thamNien;

	// Get current year
	LocalDate currentdate = LocalDate.now();
	int currentYear = currentdate.getYear();

	// 2. Get, set methods

	public int getFirstYearTeach() {
		return firstYearTeach;
	}

	public void setFirstYearTeach(int firstYearTeach) {
		this.firstYearTeach = firstYearTeach;
	}

	public int getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(int chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public int getThamNien() {
		return thamNien;
	}

	// 3. Constructors

	public GiaoVien() {
//		super();
	}

	public GiaoVien(String hoTen, int namSinh, String noiSinh, String diaChi) {
		super(hoTen, namSinh, noiSinh, diaChi);
		// TODO Auto-generated constructor stub
	}

	public GiaoVien(String hoTen, int namSinh, String noiSinh, String diaChi, int firstYearTeach, int chuyenMon) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.firstYearTeach = firstYearTeach;
		this.chuyenMon = chuyenMon;
	}


	public GiaoVien(String hoTen, int namSinh, String noiSinh, String diaChi, int firstYearTeach, int chuyenMon, int thamNien) {
		super(hoTen, namSinh, noiSinh, diaChi);
		this.firstYearTeach = firstYearTeach;
		this.chuyenMon = chuyenMon;
		this.thamNien = thamNien;
	}

	// 4. Input, Output Methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		boolean stop = true;
		do {
			System.out.print("Nhập Chuyen Mon : ");
			System.out.println("Vui long chon 1. tu nhien hoac 2. xa hoi:");
			this.chuyenMon = Integer.parseInt(scan.nextLine());
			if (chuyenMon != 1 || chuyenMon != 2) {
				stop = false;
			}
		} while (stop);

	}

	@Override
	public void xuat() {
		super.xuat();
		if (this.chuyenMon == 1) {
			System.out.println("\t Tham nien: " + this.thamNien + "\t Chuyen mon: " + "Tu Nhien");
		} else {
			System.out.println("\t Tham nien: " + this.thamNien + "\t Chuyen mon: " + "Xa Hoi");
		}
	}

	// 5. Business Methods

	public void tinhThamNien() {
		this.thamNien = currentYear - this.firstYearTeach;
	}

}
