// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_EXPRESSION
// SKIP_TXT

/*
 * TESTCASE NUMBER: 1
 * ISSUES: KT-28362
 */
fun case_1(x: Any) {
    if (x is Interface1) {
        if (x is Interface2) {
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any")!>x<!>.itest()
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any")!>x<!>.itest1()
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any")!>x<!>.itest2()
        }
    }
}

/*
 * TESTCASE NUMBER: 2
 * ISSUES: KT-28362
 */
fun case_2(x: Any) {
    if (x is Interface2) {
        if (x is Interface1) {
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & Interface1 & kotlin.Any")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & Interface1 & kotlin.Any")!>x<!>.itest0()
        }
    }
}

/*
 * TESTCASE NUMBER: 3
 * ISSUES: KT-28362
 */
fun case_3(x: Any) {
    if (x is Interface1) {
        if (x is Interface2) {
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface1 & Interface2 & kotlin.Any")!>x<!>.itest000()
        }
    }
}

/*
 * TESTCASE NUMBER: 4
 * ISSUES: KT-28362
 */
fun case_4(x: Any) {
    if (x is Interface2) {
        if (x is Interface1) {
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & Interface1 & kotlin.Any")!>x<!>
            <!DEBUG_INFO_EXPRESSION_TYPE("Interface2 & Interface1 & kotlin.Any")!>x<!>.itest0000()
        }
    }
}
