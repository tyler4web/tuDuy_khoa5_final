package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.util.Scanner;

/*
 * Mục đích: Tạo lớp superclass để lưu trữ và xử lý lien quan thanh vien truong hoc
 * Người tạo: Bui Quoc Trieu
 * Ngày tạo: 04/01/2020
 * Version: 1.0
 * */
public abstract class ThanhVien {

	// 1. Attributes
	protected String hoTen;
	protected int namSinh;
	protected String noiSinh;
	protected String diaChi;
	
	// 2. Get, set methods
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	// 3. Constructors
	public ThanhVien() {
		
	}
	
	public ThanhVien(String hoTen, int namSinh, String noiSinh, String diaChi) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}
	
	// 4. Input, Output Methods
	public void nhap(Scanner scan) {
		System.out.print("Nhập Họ Tên: ");
		this.hoTen = scan.nextLine();
	
		System.out.print("Nhập Năm Sinh:");
		this.namSinh = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập nơi sinh: ");
		this.noiSinh = scan.nextLine();
	
		System.out.print("Nhập địa chỉ: ");
		this.diaChi = scan.nextLine();
	
	
	}
	
	public void xuat() {
		System.out.print("Họ Tên:" + this.hoTen +"\t Năm Sinh: " + this.namSinh
				+ "\t Nơi Sinh: " + this.noiSinh + "\t Địa Chỉ: " + this.diaChi);
	}
	// 5. Business Methods
}
