package com.example.studentportal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class PortalActivity : AppCompatActivity() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals){ portalItem: Portal ->
        itemClicked(portalItem)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        rvPortal.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvPortal.adapter = portalAdapter

        for (i in Portal.PORTAL_NAMES.indices) {
            portals.add(Portal(Portal.PORTAL_NAMES[i], Portal.PORTAL_URLS[i]))
        }

        val portal = intent.getParcelableExtra<Portal>(PORTAL_EXTRA)

        if (portal != null) {
            portals.add(portal)
        }

        portalAdapter.notifyDataSetChanged()

        btnAddPortal.setOnClickListener { onAddClick() }
    }

    private fun onAddClick() {
        val portalActivityIntent = Intent(this, CreatePortalActivity::class.java)
        startActivity(portalActivityIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun itemClicked(portalItem: Portal) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        customTabsIntent.launchUrl(this, Uri.parse(portalItem.url))
    }

    companion object {
        const val PORTAL_EXTRA = "PORTAL_EXTRA"
    }
}

