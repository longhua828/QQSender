package com.violetgo.qqsender.QQCore.bean.msg;

import java.util.List;

public class MessageValue {
	private long msg_id;
	private long from_uin;
	private long to_uin;
	private long msg_id2;
	private long msg_type;
	private long reply_ip;
	private long group_code;
	private long send_uin;
	private long seq;
	private long time;
	private long info_seq;
	private List<Object> content;

	public long getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(long msg_id) {
		this.msg_id = msg_id;
	}

	public long getFrom_uin() {
		return from_uin;
	}

	public void setFrom_uin(long from_uin) {
		this.from_uin = from_uin;
	}

	public long getTo_uin() {
		return to_uin;
	}

	public void setTo_uin(long to_uin) {
		this.to_uin = to_uin;
	}

	public long getMsg_id2() {
		return msg_id2;
	}

	public void setMsg_id2(long msg_id2) {
		this.msg_id2 = msg_id2;
	}

	public long getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(long msg_type) {
		this.msg_type = msg_type;
	}

	public long getReply_ip() {
		return reply_ip;
	}

	public void setReply_ip(long reply_ip) {
		this.reply_ip = reply_ip;
	}

	public long getGroup_code() {
		return group_code;
	}

	public void setGroup_code(long group_code) {
		this.group_code = group_code;
	}

	public long getSend_uin() {
		return send_uin;
	}

	public void setSend_uin(long send_uin) {
		this.send_uin = send_uin;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getInfo_seq() {
		return info_seq;
	}

	public void setInfo_seq(long info_seq) {
		this.info_seq = info_seq;
	}

	public List<Object> getContent() {
		return content;
	}

	public void setContent(List<Object> content) {
		this.content = content;
	}

}
