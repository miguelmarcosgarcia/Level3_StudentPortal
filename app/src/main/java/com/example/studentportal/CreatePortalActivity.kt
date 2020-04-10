package com.example.studentportal

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_portal.*

class CreatePortalActivity : AppCompatActivity() {

    private val portals = arrayListOf<Portal>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)
        btnAddPortal.setOnClickListener { initViews() }
    }

    private fun initViews() {

        val portalName = etTitle.text.toString()
        val portalUrl = etUrl.text.toString()

        val portal = Portal(
            portalName,
            portalUrl
        )

        portals.add(portal)

        val portalActivityIntent = Intent(this, PortalActivity::class.java)
        portalActivityIntent.putExtra(PortalActivity.PORTAL_EXTRA, portal)
        startActivity(portalActivityIntent)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }



}