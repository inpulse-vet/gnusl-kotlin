const std = @import("std");

pub fn build(b: *std.Build) !void {
    const target = b.standardTargetOptions(.{});
    const optimize = b.standardOptimizeOption(.{});

    const sh = try b.findProgram(&.{"sh"}, &.{});
    const autoreconf_dependency = b.addSystemCommand(&.{ sh, "autoreconf", "-i", "-f", "-v"});
    autoreconf_dependency.setCwd(b.path("../gsl/"));

    const gsl = b.addSharedLibrary(.{
        .name = "gsl",
        .target = target,
        .optimize = optimize,
        .version = .{ .major = 1, .minor = 2, .patch = 3 },
    });

    b.default_step.dependOn(&b.addInstallFile(autoreconf_dependency.captureStdOut(), "autoreconf.txt").step);

    const sources = [_][] const u8 {
        "../gsl/vector/vector.c",
    };
    gsl.addCSourceFiles(.{ .files = &sources} );
    // gsl.addCSourceFile(.{ .file = b.path("../gsl/vector/vector.c"), });

    b.installArtifact(gsl);
}