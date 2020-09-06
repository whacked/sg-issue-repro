with import <nixpkgs> {};

stdenv.mkDerivation rec {
    name = "test";
    env = buildEnv { name = name; paths = buildInputs; };
    buildInputs = [
      clojure
      watchexec
    ];

    shellHook = ''
      alias run-compiler='lein cljsbuild auto'
      alias run-watch='watchexec --restart --no-ignore --watch out/ node out/index.js'
    '';
}

