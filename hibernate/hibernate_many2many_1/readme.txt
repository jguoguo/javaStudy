hibernate��Զ����ӳ�䣨User--->role)

		<set name="roles" table="t_user_role">
			<key column="user_id"/>
			<many-to-many class="com.bjpowernode.hibernate.Role" column="role_id"></many-to-many>
		</set>