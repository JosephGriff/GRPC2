// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: userP.proto

package ie.gmit.ds;

public interface PasswordHashResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.PasswordHashResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 userId = 1;</code>
   */
  int getUserId();

  /**
   * <code>bytes hashedPassword = 2;</code>
   */
  com.google.protobuf.ByteString getHashedPassword();

  /**
   * <code>bytes salt = 3;</code>
   */
  com.google.protobuf.ByteString getSalt();
}
