/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.EmailAddressModel;
import com.liferay.portal.model.EmailAddressSoap;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the EmailAddress service. Represents a row in the &quot;EmailAddress&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.EmailAddressModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmailAddressImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailAddressImpl
 * @see com.liferay.portal.model.EmailAddress
 * @see com.liferay.portal.model.EmailAddressModel
 * @generated
 */
@JSON(strict = true)
public class EmailAddressModelImpl extends BaseModelImpl<EmailAddress>
	implements EmailAddressModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a email address model instance should use the {@link com.liferay.portal.model.EmailAddress} interface instead.
	 */
	public static final String TABLE_NAME = "EmailAddress";
	public static final Object[][] TABLE_COLUMNS = {
			{ "emailAddressId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "address", Types.VARCHAR },
			{ "typeId", Types.INTEGER },
			{ "primary_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table EmailAddress (emailAddressId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,address VARCHAR(75) null,typeId INTEGER,primary_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table EmailAddress";
	public static final String ORDER_BY_JPQL = " ORDER BY emailAddress.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EmailAddress.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.EmailAddress"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.EmailAddress"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.EmailAddress"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long COMPANYID_COLUMN_BITMASK = 4L;
	public static long PRIMARY_COLUMN_BITMASK = 8L;
	public static long USERID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EmailAddress toModel(EmailAddressSoap soapModel) {
		EmailAddress model = new EmailAddressImpl();

		model.setEmailAddressId(soapModel.getEmailAddressId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setAddress(soapModel.getAddress());
		model.setTypeId(soapModel.getTypeId());
		model.setPrimary(soapModel.getPrimary());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EmailAddress> toModels(EmailAddressSoap[] soapModels) {
		List<EmailAddress> models = new ArrayList<EmailAddress>(soapModels.length);

		for (EmailAddressSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.EmailAddress"));

	public EmailAddressModelImpl() {
	}

	public long getPrimaryKey() {
		return _emailAddressId;
	}

	public void setPrimaryKey(long primaryKey) {
		setEmailAddressId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_emailAddressId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return EmailAddress.class;
	}

	public String getModelClassName() {
		return EmailAddress.class.getName();
	}

	@JSON
	public long getEmailAddressId() {
		return _emailAddressId;
	}

	public void setEmailAddressId(long emailAddressId) {
		_emailAddressId = emailAddressId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@JSON
	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	public int getTypeId() {
		return _typeId;
	}

	public void setTypeId(int typeId) {
		_typeId = typeId;
	}

	@JSON
	public boolean getPrimary() {
		return _primary;
	}

	public boolean isPrimary() {
		return _primary;
	}

	public void setPrimary(boolean primary) {
		_columnBitmask |= PRIMARY_COLUMN_BITMASK;

		if (!_setOriginalPrimary) {
			_setOriginalPrimary = true;

			_originalPrimary = _primary;
		}

		_primary = primary;
	}

	public boolean getOriginalPrimary() {
		return _originalPrimary;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public EmailAddress toEscapedModel() {
		if (isEscapedModel()) {
			return (EmailAddress)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (EmailAddress)ProxyUtil.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					EmailAddress.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		EmailAddressImpl emailAddressImpl = new EmailAddressImpl();

		emailAddressImpl.setEmailAddressId(getEmailAddressId());
		emailAddressImpl.setCompanyId(getCompanyId());
		emailAddressImpl.setUserId(getUserId());
		emailAddressImpl.setUserName(getUserName());
		emailAddressImpl.setCreateDate(getCreateDate());
		emailAddressImpl.setModifiedDate(getModifiedDate());
		emailAddressImpl.setClassNameId(getClassNameId());
		emailAddressImpl.setClassPK(getClassPK());
		emailAddressImpl.setAddress(getAddress());
		emailAddressImpl.setTypeId(getTypeId());
		emailAddressImpl.setPrimary(getPrimary());

		emailAddressImpl.resetOriginalValues();

		return emailAddressImpl;
	}

	public int compareTo(EmailAddress emailAddress) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), emailAddress.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EmailAddress emailAddress = null;

		try {
			emailAddress = (EmailAddress)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = emailAddress.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		EmailAddressModelImpl emailAddressModelImpl = this;

		emailAddressModelImpl._originalCompanyId = emailAddressModelImpl._companyId;

		emailAddressModelImpl._setOriginalCompanyId = false;

		emailAddressModelImpl._originalUserId = emailAddressModelImpl._userId;

		emailAddressModelImpl._setOriginalUserId = false;

		emailAddressModelImpl._originalClassNameId = emailAddressModelImpl._classNameId;

		emailAddressModelImpl._setOriginalClassNameId = false;

		emailAddressModelImpl._originalClassPK = emailAddressModelImpl._classPK;

		emailAddressModelImpl._setOriginalClassPK = false;

		emailAddressModelImpl._originalPrimary = emailAddressModelImpl._primary;

		emailAddressModelImpl._setOriginalPrimary = false;

		emailAddressModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EmailAddress> toCacheModel() {
		EmailAddressCacheModel emailAddressCacheModel = new EmailAddressCacheModel();

		emailAddressCacheModel.emailAddressId = getEmailAddressId();

		emailAddressCacheModel.companyId = getCompanyId();

		emailAddressCacheModel.userId = getUserId();

		emailAddressCacheModel.userName = getUserName();

		String userName = emailAddressCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			emailAddressCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			emailAddressCacheModel.createDate = createDate.getTime();
		}
		else {
			emailAddressCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			emailAddressCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			emailAddressCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		emailAddressCacheModel.classNameId = getClassNameId();

		emailAddressCacheModel.classPK = getClassPK();

		emailAddressCacheModel.address = getAddress();

		String address = emailAddressCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			emailAddressCacheModel.address = null;
		}

		emailAddressCacheModel.typeId = getTypeId();

		emailAddressCacheModel.primary = getPrimary();

		return emailAddressCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{emailAddressId=");
		sb.append(getEmailAddressId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", primary=");
		sb.append(getPrimary());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.EmailAddress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>emailAddressId</column-name><column-value><![CDATA[");
		sb.append(getEmailAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>primary</column-name><column-value><![CDATA[");
		sb.append(getPrimary());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EmailAddress.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			EmailAddress.class
		};
	private long _emailAddressId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private String _address;
	private int _typeId;
	private boolean _primary;
	private boolean _originalPrimary;
	private boolean _setOriginalPrimary;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private EmailAddress _escapedModelProxy;
}