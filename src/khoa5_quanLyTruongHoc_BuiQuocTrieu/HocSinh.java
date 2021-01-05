package khoa5_quanLyTruongHoc_BuiQuocTrieu;

import java.util.Scanner;

public class HocSinh extends ThanhVien {

	// 1. ATTRIBUTES
	protected float diemToan;
	protected float diemVan;
	protected float diemNgoaiNgu;
	protected float diemTB;
	protected String xepLoai;
	public static int diem5 = 5;
	public static int diem7 = 7;
	public static int diem8 = 8;
	public static int diem9 = 9;

	// 2 GET, SET METHODS
	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemVan() {
		return diemVan;
	}

	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	public float getDiemNgoaiNgu() {
		return diemNgoaiNgu;
	}

	public void setDiemNgoaiNgu(float diemNgoaiNgu) {
		this.diemNgoaiNgu = diemNgoaiNgu;
	}

	public float getDiemTB() {
		return diemTB;
	}
	
	public String getXepLoai() {
		return xepLoai;
	}
	
	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}
	
	// 3. CONSTRUCTORS


	public HocSinh() {
	}

	public HocSinh(String hoTen, int namSinh, String noiSinh, String diaChi) {
		super(hoTen, namSinh, noiSinh, diaChi);
	}

	public HocSinh(float diemToan, float diemVan, float diemNgoaiNgu) {
		super();
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemNgoaiNgu = diemNgoaiNgu;
	}
	

	public HocSinh(float diemToan, float diemVan, float diemNgoaiNgu, float diemTB, String xepLoai) {
		super();
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemNgoaiNgu = diemNgoaiNgu;
		this.diemTB = diemTB;
		this.xepLoai = xepLoai;
	}

	// 4. INPUT, OUTPUT METHODS
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Nhập điểm toán:");
		this.diemToan = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập điểm văn:");
		this.diemVan = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập điểm ngoại ngữ:");
		this.diemNgoaiNgu = Integer.parseInt(scan.nextLine());
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\t Điểm toán:" + this.diemToan + "\t Điểm Văn: " + this.diemVan + "\t Điểm Ngoại Ngữ: "
				+ this.diemNgoaiNgu + "\t Điểm TB: " + this.diemTB  + "\t Xep Loai: " + this.xepLoai);
	}

	// 5. BUSINESS METHODS

	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemNgoaiNgu + this.diemVan) / 3;
	}
}
