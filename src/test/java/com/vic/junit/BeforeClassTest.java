package com.vic.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * 1. 一个JUnit4的单元测试用例执行顺序为: @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
 * 2. 每一个测试方法的调用顺序为: @Before -> @Test -> @After
 * @author victor
 */

//按字典顺序执行方法
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BeforeClassTest extends SuperTest {

	/**
	 * 每个方法@Test方法执行前都会执行它
	 * 方法不能声明为static
	 */
	@Before
	public void before() {
		System.out.println("Before");
	}

	/**
	 * 在类中只运行一次，必须声明为public static void no-args
	 * 右击类->Run as->JUnit Test
	 */
	@BeforeClass
	public static void onlyOnce() {
		System.out.println("BeforeClass");
	}
	
	@Test
	public void one() {
		System.out.println("one");
	}

	@Test
	public void atwo() {
		System.out.println("two");
	}
	
	/**
	 * 1. 每个方法@Test方法执行后都会执行它
	 * 2. 如果父类中有多个@After方法，执行顺序未知
	 * 3. 先执行子类的@After方法，后执行父类中的@After方法
	 * 4. 如果子类覆盖了父类中的@After方法，则执行子类方法，不再执行父类方法
	 * 
	 */
	@After
	public void after2() {
		System.out.println("After2");
	}
	
	@Ignore("not ready yet")
	@After
	public void after3() {
		System.out.println("After3");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	
}
