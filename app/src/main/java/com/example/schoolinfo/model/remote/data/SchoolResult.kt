package com.example.schoolinfo.model.remote.data

import android.os.Parcel
import android.os.Parcelable


data class SchoolResult(
    val academicopportunities1: String,
    val academicopportunities2: String,
    val admissionspriority11: String,
    val admissionspriority21: String,
    val admissionspriority31: String,
    val attendance_rate: String,
    val bbl: String,
    val bin: String,
    val boro: String,
    val borough: String,
    val building_code: String,
    val bus: String,
    val census_tract: String,
    val city: String,
    val code1: String,
    val community_board: String,
    val council_district: String,
    val dbn: String,
    val directions1: String,
    val ell_programs: String,
    val extracurricular_activities: String,
    val fax_number: String,
    val finalgrades: String,
    val grade9geapplicants1: String,
    val grade9geapplicantsperseat1: String,
    val grade9gefilledflag1: String,
    val grade9swdapplicants1: String,
    val grade9swdapplicantsperseat1: String,
    val grade9swdfilledflag1: String,
    val grades2018: String,
    val interest1: String,
    val latitude: String,
    val location: String,
    val longitude: String,
    val method1: String,
    val neighborhood: String,
    val nta: String,
    val offer_rate1: String,
    val overview_paragraph: String,
    val pct_stu_enough_variety: String,
    val pct_stu_safe: String,
    val phone_number: String,
    val primary_address_line_1: String,
    val program1: String,
    val requirement1_1: String,
    val requirement2_1: String,
    val requirement3_1: String,
    val requirement4_1: String,
    val requirement5_1: String,
    val school_10th_seats: String,
    val school_accessibility_description: String,
    val school_email: String,
    val school_name: String,
    val school_sports: String,
    val seats101: String,
    val seats9ge1: String,
    val seats9swd1: String,
    val state_code: String,
    val subway: String,
    val total_students: String,
    val website: String,
    val zip: String,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(academicopportunities1)
        parcel.writeString(academicopportunities2)
        parcel.writeString(admissionspriority11)
        parcel.writeString(admissionspriority21)
        parcel.writeString(admissionspriority31)
        parcel.writeString(attendance_rate)
        parcel.writeString(bbl)
        parcel.writeString(bin)
        parcel.writeString(boro)
        parcel.writeString(borough)
        parcel.writeString(building_code)
        parcel.writeString(bus)
        parcel.writeString(census_tract)
        parcel.writeString(city)
        parcel.writeString(code1)
        parcel.writeString(community_board)
        parcel.writeString(council_district)
        parcel.writeString(dbn)
        parcel.writeString(directions1)
        parcel.writeString(ell_programs)
        parcel.writeString(extracurricular_activities)
        parcel.writeString(fax_number)
        parcel.writeString(finalgrades)
        parcel.writeString(grade9geapplicants1)
        parcel.writeString(grade9geapplicantsperseat1)
        parcel.writeString(grade9gefilledflag1)
        parcel.writeString(grade9swdapplicants1)
        parcel.writeString(grade9swdapplicantsperseat1)
        parcel.writeString(grade9swdfilledflag1)
        parcel.writeString(grades2018)
        parcel.writeString(interest1)
        parcel.writeString(latitude)
        parcel.writeString(location)
        parcel.writeString(longitude)
        parcel.writeString(method1)
        parcel.writeString(neighborhood)
        parcel.writeString(nta)
        parcel.writeString(offer_rate1)
        parcel.writeString(overview_paragraph)
        parcel.writeString(pct_stu_enough_variety)
        parcel.writeString(pct_stu_safe)
        parcel.writeString(phone_number)
        parcel.writeString(primary_address_line_1)
        parcel.writeString(program1)
        parcel.writeString(requirement1_1)
        parcel.writeString(requirement2_1)
        parcel.writeString(requirement3_1)
        parcel.writeString(requirement4_1)
        parcel.writeString(requirement5_1)
        parcel.writeString(school_10th_seats)
        parcel.writeString(school_accessibility_description)
        parcel.writeString(school_email)
        parcel.writeString(school_name)
        parcel.writeString(school_sports)
        parcel.writeString(seats101)
        parcel.writeString(seats9ge1)
        parcel.writeString(seats9swd1)
        parcel.writeString(state_code)
        parcel.writeString(subway)
        parcel.writeString(total_students)
        parcel.writeString(website)
        parcel.writeString(zip)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SchoolResult> {
        override fun createFromParcel(parcel: Parcel): SchoolResult {
            return SchoolResult(parcel)
        }

        override fun newArray(size: Int): Array<SchoolResult?> {
            return arrayOfNulls(size)
        }
    }
}
