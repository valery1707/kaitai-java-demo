#!/usr/bin/env bash
set -e

for d in */; do
  pushd $d
  ./ci_build.sh
  popd
done
