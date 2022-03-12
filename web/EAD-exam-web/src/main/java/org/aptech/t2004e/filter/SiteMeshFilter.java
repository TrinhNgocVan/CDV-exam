package org.aptech.t2004e.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/themes/admin/decorator/admin.jsp")
		   .addExcludedPath("/login")
		   .addExcludedPath("/accountRegister/form")
		   .addExcludedPath("/accountRegister/save")
		   .addExcludedPath("/passwordChange");
	
	}
}