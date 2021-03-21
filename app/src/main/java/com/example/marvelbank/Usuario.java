package com.example.marvelbank;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

  private String usuario;
  private String senha;

  public Usuario(String usuario, String senha) {
    this.usuario = usuario;
    this.senha = senha;
  }

  private Usuario(Parcel p) {
    this.usuario = p.readString();
    this.senha = p.readString();
  }

  public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
    @Override
    public Usuario createFromParcel(Parcel p) {
      return new Usuario(p);
    }

    @Override
    public Usuario[] newArray(int size) {
      return new Usuario[size];
    }
  };

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(this.usuario);
    parcel.writeString(this.senha);
  }

}
